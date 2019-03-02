//�������� �Խ��ǰ� ���õ� ��� ��û�� ó���ϴ� ���� ��Ʈ�ѷ�
//�������װ� ���õ� ��û: �۾����û, ������û, ����Ʈ��û, ������û...
package notice.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import board.model.service.BoardService;
import notice.model.Notice;

public class NoticeController {
	String TAG=this.getClass().getName();
	
	//DI�� �����Ϸ���, ���Թ޴� ��ü�� ������ü�� �ƴ�, �ֻ��� ��ü�� �����ؾ�
	//���� ��ü�� ����Ǵ��� ���� Ŭ������ ������ ���� �ʴ´�.
	private BoardService boardService;
	
	//���Թޱ� ���� setter �߰�!!
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	//jsp ������ ���� �Ķ���͸� ���� ���� �ʾƵ� �ȴ�!!
	@RequestMapping("/notice/insert")
	public String insert(Notice notice) {
		//Notice Ŭ������ �Ӽ��� �Ķ���͸��� ��ġ�ؾ� ��.. 
		//�׷��� �ڵ����� �Ķ���Ͱ��� DTO �����..
		//dao���� �Ͻ�Ű��!!
		System.out.println(TAG+"�Ѱܹ��� �ۼ��ڴ� "+notice.getWriter());
		System.out.println(TAG+"�Ѱܹ��� ������ "+notice.getTitle());
		System.out.println(TAG+"�Ѱܹ��� ������ "+notice.getContent());
		boardService.insert(notice);
		return "notice/list";
	} 
	
}








