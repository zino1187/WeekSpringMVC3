package db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
mybatis �� �̿��Ͽ� �������� �����ϱ� ���ؼ��� session ��ü�� �ʿ��ѵ�,
�� session ��ü�� SqlSessionFactory �κ��� ���;� �Ѵ�..
���� �� Ŭ������ SqlSessionFactory ���� �ڵ带 �ߺ����� �ʱ� ���� 
�� �����ϱ� ���� �����Ѵ�!!
*/
public class MybatisManager {
	private static MybatisManager instance;
	
	//SqlSession �� ��Ƴ��� �����ϴ� ��ü
	private SqlSessionFactory sqlSessionFactory=null;
	
	//�ƹ��� new ���ϰ� �����ڸ� ���´�...
	private MybatisManager() {
		//��� ������ Ŭ������ �ƴ� ���� ��Ű���� �ƴ� ���丮 ���
		//.���� �ƴ϶� /�� �̿��ؾ� �Ѵ�..
		String resource = "mybatis/config/config.xml";
		InputStream inputStream;
		
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//�����ڸ� ���Ƴ��ұ� ������ getter�� �������ش�!!
	//getter�� �ν��Ͻ� �޼����̱� ������ �ܺο��� new ���� �ʰ�� ���ٺҰ���
	//���� �ƿ� static ���� �����Ͽ� new ���� �ʰ� �����Ҽ� �ִ� �����޼���
	//�� �����Ѵ�!!
	public static MybatisManager getInstance() {
		//�������� �� �޼��带 ȣ�������� , instance ������ null�� ���������
		//�����ϹǷ�, ���⼭ null���� ���θ� �Ǵ��Ͽ� null �̸� new ����!!
		if(instance == null) {
			instance = new MybatisManager();
		}
		return instance;
	}
	
	//���� ���!!!
	public SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
	//���� �ݱ�!!
	public void release(SqlSession session) {
		session.close();
	}
}	






