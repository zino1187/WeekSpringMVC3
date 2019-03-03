package board.model.service;

import java.util.List;

import notice.model.Notice;
import notice.model.NoticeDAO;

//DAO를 주입받아야 한다!!
public class BoardServiceImpl implements BoardService{
	String TAG=this.getClass().getName();
	
	private NoticeDAO noticeDAO;
	
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	public void insert(Notice notice) {
		noticeDAO.insert(notice); //DAO의 메서드 호출
		System.out.println(TAG+" insert 호출");
	}
	
	
	public List selectAll() {
		//dao 에게 일 시키기!!
		List list=null;
		list=noticeDAO.selectAll();
		return list;
	}
	
	public Notice select(int notice_id) {
		Notice notice=null;
		notice=noticeDAO.select(notice_id);
		return notice;
	}
	
	public int update(Notice notice) {
		int result=0;
		result=noticeDAO.update(notice);
		return result;
	}
	
	public int delete(int notice_id) {
		int result=0;
		result=noticeDAO.delete(notice_id);
		return result;
	}
}















