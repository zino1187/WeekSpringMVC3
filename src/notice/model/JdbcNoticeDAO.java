package notice.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.PoolManager;

/*
 * Ŀ�ؼ� Ǯ ���� ��� 
 * 1) ���� �����ڰ� �ڵ� �ۼ� (�����ڵ鰣 ���� �Ƿ��� ���� �¿���)
 * 2) ���̺귯���� ���� ���(����ġ DBCP-Apache Common DataBase
 *     Connection Pool)
 * 3) �����̳� WAS� ��ü������ �����ϴ� JNDI �� ���� ���
 *     Java Naming Directory Interface 
 *     Ŭ�������� ����� �ڿ��� ���� �ڵ带 Ŭ�������� ���� ����, �ܺ�
 *     ���� xml ���Ͽ� �ּ�, �� �̸��� �̿��Ͽ� �ڿ��� �����ϴ� ��� 
 *     ex) �����ͺ��̽��� ���� ������ Ŭ������ ���� �ʰ� �ܺ� ���������� 
 *     xml �� �δ� ���
 * */
public class JdbcNoticeDAO implements NoticeDAO{
										//is a : ���� �ڷ����� �ȴ�!!
	String TAG=this.getClass().getName();//���� Ŭ������ ���!
	
	//�̱������� ����� ��ü ��������!!
	PoolManager pool=PoolManager.getInstance();

	//jdbc ����� ������ ��������� �̿��ϰڴ�...	
	public int insert(Notice notice) {
		Connection con=null;//���� ������ ���� ��ü
		PreparedStatement pstmt=null;//������ ���� ��ü
		int result=0;
		
		try {
			con=pool.getConnection(); //�뿩!!
			String sql="insert into notice(notice_id,writer,title,content)";
			sql+=" values(seq_notice.nextval, ?,?,?)";
			
			//������ ���� ��ü ����
			pstmt=con.prepareStatement(sql);
			//DML : insert ,update, delete ���� executeUpdate()�̿�
			pstmt.setString(1,notice.getWriter());
			pstmt.setString(2,notice.getTitle());
			pstmt.setString(3,notice.getContent());
			
			result=pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//����ߴ� �����ͺ��̽� ���� ��ü���� ��� �ݾƾ� ��...
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
		System.out.println(TAG+" insert ȣ�� ");
		return result;//���� ���� ����� ��ȯ!! 1����, 0����
	}
	
	//����Ŭ�� �ִ� ��� �Խù� ��������!! 
	public List selectAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List list=new ArrayList();//Notice ���� ��Ե� List
		//ex) �Խù��� �� 3�� Notice�� 3�� �����Ǿ� List�ȿ� ž��!!
		
		con=pool.getConnection();//Ǯ�� ���� Ŀ�ؼ� ���!!
		String sql="select * from notice order by notice_id desc";
		try {
			pstmt=con.prepareStatement(sql);//���� ��ü ����!!
			//ResultSet ��?? ���ڵ带 ���� ��ü �� ǥ�� ����!!
			rs=pstmt.executeQuery();//�� ������ rs ������!!
			//rs�� �� �Ҹ�ǹǷ�, rs�� �����ϴ� ��� ���ڵ带 Notice ����
			//��� �ٽ� �� ������ Notice�� �÷��� �����ӿ��� �����ϴ� ��ü��
			//������ �ִ� ��ü�� List�� ��ڴ�!!
			while(rs.next()) {
				Notice notice = new Notice();//Empty �� ��ü�ϳ� ����
				notice.setNotice_id(rs.getInt("notice_id"));
				notice.setWriter(rs.getString("writer"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setRegdate(rs.getString("regdate"));
				notice.setHit(rs.getInt("hit"));
				list.add(notice);//����Ʈ�� ���!!!
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//�ݳ�!!
			pool.release(con, pstmt, rs);
		}
		return list;//����Ʈ ��ȯ
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
			
			if(rs.next()) {//���ڵ尡 �ִٸ�...
				notice = new Notice();//Empty �� ��ü�ϳ� ����
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















