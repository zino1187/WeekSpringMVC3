package notice.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.PoolManager;

/*
 * 커넥션 풀 구현 방법 
 * 1) 직접 개발자가 코드 작성 (개발자들간 개인 실력차 성능 좌우죔)
 * 2) 라이브러리를 쓰는 방법(아파치 DBCP-Apache Common DataBase
 *     Connection Pool)
 * 3) 톰켓이나 WAS등에 자체적으로 지원하는 JNDI 를 쓰는 방법
 *     Java Naming Directory Interface 
 *     클래스에서 사용할 자원에 대한 코드를 클래스내에 두지 말고, 외부
 *     설정 xml 파일에 둬서, 그 이름을 이용하여 자원을 접근하는 방식 
 *     ex) 데이터베이스에 대한 정보를 클래스에 두지 않고 외부 설정파일인 
 *     xml 에 두는 방법
 * */
public class JdbcNoticeDAO implements NoticeDAO{
										//is a : 같은 자료형이 된다!!
	String TAG=this.getClass().getName();//현재 클래스명 담김!
	
	//싱글턴으로 선언된 객체 가져오기!!
	PoolManager pool=PoolManager.getInstance();

	//jdbc 방식의 데이터 연동기술을 이용하겠다...	
	public int insert(Notice notice) {
		Connection con=null;//접속 정보를 가진 객체
		PreparedStatement pstmt=null;//쿼리문 수행 객체
		int result=0;
		
		try {
			con=pool.getConnection(); //대여!!
			String sql="insert into notice(notice_id,writer,title,content)";
			sql+=" values(seq_notice.nextval, ?,?,?)";
			
			//쿼리문 수행 객체 생성
			pstmt=con.prepareStatement(sql);
			//DML : insert ,update, delete 문은 executeUpdate()이용
			pstmt.setString(1,notice.getWriter());
			pstmt.setString(2,notice.getTitle());
			pstmt.setString(3,notice.getContent());
			
			result=pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//사용했던 데이터베이스 관련 객체들을 모두 닫아야 함...
			if(pstmt !=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con !=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		System.out.println(TAG+" insert 호출 ");
		return result;//쿼리 수행 결과를 반환!! 1성공, 0실패
	}
	
	//오라클에 있는 모든 게시물 가져오기!! 
	public List selectAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List list=new ArrayList();//Notice 들을 담게될 List
		//ex) 게시물이 총 3개 Notice도 3개 생성되어 List안에 탑재!!
		
		con=pool.getConnection();//풀로 부터 커넥션 얻기!!
		String sql="select * from notice order by notice_id desc";
		try {
			pstmt=con.prepareStatement(sql);//쿼리 객체 생성!!
			//ResultSet 은?? 레코드를 담은 객체 즉 표와 같다!!
			rs=pstmt.executeQuery();//이 시점에 rs 생성됨!!
			//rs는 곧 소멸되므로, rs에 존재하는 모든 레코드를 Notice 각각
			//담고 다시 이 각각의 Notice를 컬렉션 프레임웍이 제공하는 객체중
			//순서가 있는 객체인 List에 담겠다!!
			while(rs.next()) {
				Notice notice = new Notice();//Empty 된 객체하나 생성
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setWriter(rs.getString("writer"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setRegdate(rs.getString("regdate"));
				notice.setHit(rs.getInt("hit"));
				list.add(notice);//리스트에 담기!!!
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//반납!!
			pool.release(con, pstmt, rs);
		}
		return list;//리스트 반환
	}
	
	public Notice select(int notice_id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		con=pool.getConnection();
		String sql="select * from notice where notice_id=?";
		Notice notice=null;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, notice_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {//레코드가 있다면...
				notice = new Notice();//Empty 된 객체하나 생성
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setWriter(rs.getString("writer"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setRegdate(rs.getString("regdate"));
				notice.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			pool.release(con, pstmt, rs);
		}
		return notice;
	}
}















