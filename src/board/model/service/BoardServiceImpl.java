package board.model.service;

import java.util.List;

import notice.model.Notice;
import notice.model.NoticeDAO;

//DAO�� ���Թ޾ƾ� �Ѵ�!!
public class BoardServiceImpl implements BoardService{
	String TAG=this.getClass().getName();
	
	private NoticeDAO noticeDAO;
	
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	public void insert(Notice notice) {
		noticeDAO.insert(notice); //DAO�� �޼��� ȣ��
		System.out.println(TAG+" insert ȣ��");
	}
	
	
	public List selectAll() {
		return null;
	}
	
}











