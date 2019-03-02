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
	
	InitialContext initCtx;//xml 검색 객체
	DataSource ds;//풀
	
	private PoolManager(){
		try {
			initCtx = new InitialContext();
			ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	//생성자를 막아놓았기 때문에, getter를 제공하여 인스턴스를 가져가게 함
	public static PoolManager getInstance() {
		//이 메서드 호출한 자가 null인객체를 가져가면 안되므로, 
		//여기서 null 여부를 판단하여 null인경우 new 하여 인스턴스를 
		//생성해주면 된다..
		if(instance ==null) {
			instance = new PoolManager();
		}
		return instance;
	}
	
	//Connection 대여 메서드!!!
	//접속이 아니라, 풀로부터 Connection 빌리는 메서드!!
	public Connection getConnection() {
		Connection con=null;
		try {
			con=ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//반납 메서드 정의
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









