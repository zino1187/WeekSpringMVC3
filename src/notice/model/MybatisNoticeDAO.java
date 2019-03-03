package notice.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import db.MybatisManager;

public class MybatisNoticeDAO implements NoticeDAO{
	MybatisManager manager=MybatisManager.getInstance();

	public int insert(Notice notice) {
		SqlSession session=null;
		session=manager.getSession();//���
		int result=session.insert("Notice.insert", notice);
		session.commit();//��ũ ���� ����!!Ȯ��!!!
		manager.release(session);//�ݳ�
		return result;
	}
	
	public List selectAll() {
		//�������� �����ϱ� ���� ��ü�� ������ ���´�!!
		SqlSession session=null;
		session=manager.getSession();//��������
		List list=session.selectList("Notice.selectAll");
		manager.release(session);//�ݱ�
		return list;
	}

	@Override
	public Notice select(int notice_id) {
		SqlSession session=null;
		session=manager.getSession();
		Notice notice=session.selectOne("Notice.select", notice_id);
		manager.release(session);
		return notice;
	}

	@Override
	public int update(Notice notice) {
		SqlSession session=null;
		session=manager.getSession();
		int result=session.update("Notice.update", notice);
		session.commit();//DML(insert ,update, delete)�� Ʈ����Ǵ��!
		manager.release(session);
		return result;
	}
	
	public int delete(int notice_id) {
		SqlSession session=null;
		session=manager.getSession();
		int result=session.delete("Notice.delete", notice_id);
		session.commit();
		manager.release(session);
		return result;
	}
}






