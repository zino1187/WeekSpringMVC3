package notice.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import db.MybatisManager;

public class MybatisNoticeDAO implements NoticeDAO{
	MybatisManager manager=MybatisManager.getInstance();

	public int insert(Notice notice) {
		return 0;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

}
