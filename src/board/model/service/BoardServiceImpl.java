package board.model.service;

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
}






