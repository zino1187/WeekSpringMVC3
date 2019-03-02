package notice.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}










