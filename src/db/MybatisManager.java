package db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
mybatis 를 이용하여 쿼리문을 수행하기 위해서는 session 객체가 필요한데,
이 session 객체는 SqlSessionFactory 로부터 얻어와야 한다..
따라서 이 클래스는 SqlSessionFactory 얻어도는 코드를 중복하지 않기 위해 
즉 재사용하기 위해 정의한다!!
*/
public class MybatisManager {
	private static MybatisManager instance;
	
	//SqlSession 을 모아놓고 관리하는 객체
	private SqlSessionFactory sqlSessionFactory=null;
	
	//아무도 new 못하게 생성자를 막는다...
	private MybatisManager() {
		//대상 파일이 클래스가 아닌 경우는 패키지가 아닌 디렉토리 취급
		//.점이 아니라 /를 이용해야 한다..
		String resource = "mybatis/config/config.xml";
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//생성자를 막아놓았기 때문에 getter를 제공해준다!!
	//getter는 인스턴스 메서드이기 때문에 외부에서 new 하지 않고는 접근불가임
	//따라서 아예 static 으로 선언하여 new 하지 않고도 접근할수 있는 정적메서드
	//로 정의한다!!
	public static MybatisManager getInstance() {
		//누군가가 이 메서드를 호출했을때 , instance 변수에 null이 들어잇으면
		//사용못하므로, 여기서 null인지 여부를 판단하여 null 이면 new 하자!!
		if(instance == null) {
			instance = new MybatisManager();
		}
		return instance;
	}
	
	//세션 얻기!!!
	public SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
	//세션 닫기!!
	public void release(SqlSession session) {
		session.close();
	}
}	






