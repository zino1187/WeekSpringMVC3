package notice.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import db.MybatisManager;

public class MybatisNoticeDAO implements NoticeDAO{
	MybatisManager manager=MybatisManager.getInstance();

	public int insert(Notice notice) {
		SqlSession session=null;
		session=manager.getSession();//취득
		int result=session.insert("Notice.insert", notice);
		session.commit();//디스크 내려 쓰기!!확정!!!
		manager.release(session);//반납
		return result;
	}
	
	public List selectAll() {
		//쿼리문을 수행하기 위한 객체인 세션을 얻어온다!!
		SqlSession session=null;
		session=manager.getSession();//빌려오기
		List list=session.selectList("Notice.selectAll");
		manager.release(session);//닫기
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
		session.commit();//DML(insert ,update, delete)은 트랜잭션대상!
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






