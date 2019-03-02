package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PoolManager {
	private static PoolManager instance=null;
	
	InitialContext initCtx;//xml �˻� ��ü
	DataSource ds;//Ǯ
	
	private PoolManager(){
		try {
			initCtx = new InitialContext();
			ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	//�����ڸ� ���Ƴ��ұ� ������, getter�� �����Ͽ� �ν��Ͻ��� �������� ��
	public static PoolManager getInstance() {
		//�� �޼��� ȣ���� �ڰ� null�ΰ�ü�� �������� �ȵǹǷ�, 
		//���⼭ null ���θ� �Ǵ��Ͽ� null�ΰ�� new �Ͽ� �ν��Ͻ��� 
		//�������ָ� �ȴ�..
		if(instance ==null) {
			instance = new PoolManager();
		}
		return instance;
	}
	
	//Connection �뿩 �޼���!!!
	//������ �ƴ϶�, Ǯ�κ��� Connection ������ �޼���!!
	public Connection getConnection() {
		Connection con=null;
		try {
			con=ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//�ݳ� �޼��� ����
	public void release(Connection con) {
		if(con !=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void release(Connection con, PreparedStatement pstmt) {
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
	public void release(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if(rs !=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

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
}









