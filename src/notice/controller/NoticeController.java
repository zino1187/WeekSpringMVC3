//�������� �Խ��ǰ� ���õ� ��� ��û�� ó���ϴ� ���� ��Ʈ�ѷ�
//�������װ� ���õ� ��û: �۾����û, ������û, ����Ʈ��û, ������û...
package notice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
		return "redirect:/notice/list";
	} 
	
	//����� ó���ϴ� �޼���
	@RequestMapping("/notice/list")
	public ModelAndView selectAll() {
		List list=null;
		list=boardService.selectAll();
		//list�� DispatcherServlet ��ǥ ��Ʈ�ѷ����� ���޵Ǿ�� �Ѵ�..
		//���� list�� ������ ��ü�� �ʿ��ѵ� ������������ Model ��ü�� 
		//�����͸� �����ϴ� ������ �����Ѵ�!!
		//��� jsp������ RequestDispatcher �� ������ ��ɰ� ���� 
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list); //list��� �̸����� list�� ����
		mav.setViewName("notice/list");
		return mav;
	}
	
	//�󼼱� ���� ��û�� ó�� 
	@RequestMapping("/notice/content")
	public ModelAndView select(@RequestParam("notice_id") int notice_id) {
		System.out.println("�Ѱܹ��� notice_id�� "+notice_id);
		Notice notice=boardService.select(notice_id);
		
		ModelAndView mav = new ModelAndView("notice/content");
		mav.addObject("notice", notice);//��� ���!!!
		System.out.println("������ "+notice.getTitle());
		return mav;
	}
}















