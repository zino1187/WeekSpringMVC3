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
		return null;
	}
	
}











