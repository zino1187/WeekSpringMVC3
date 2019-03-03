//공지사항 게시판과 관련된 모든 요청을 처리하는 하위 컨트롤러
//공지사항과 관련된 요청: 글쓰기요청, 삭제요청, 리스트요청, 수정요청...
package notice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.service.BoardService;
import notice.model.Notice;

public class NoticeController {
	String TAG=this.getClass().getName();
	
	//DI를 구현하려면, 주입받는 객체는 하위객체가 아닌, 최상위 객체로 정의해야
	//추후 객체가 변경되더라도 현재 클래스가 영향을 받지 않는다.
	private BoardService boardService;
	
	//주입받기 위해 setter 추가!!
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	//jsp 에서와 같이 파라미터를 직접 받지 않아도 된다!!
	@RequestMapping("/notice/insert")
	public String insert(Notice notice) {
		//Notice 클래스의 속성과 파라미터명이 일치해야 함.. 
		//그래야 자동으로 파라미터값이 DTO 담아짐..
		//dao에게 일시키기!!
		System.out.println(TAG+"넘겨받은 작성자는 "+notice.getWriter());
		System.out.println(TAG+"넘겨받은 제목은 "+notice.getTitle());
		System.out.println(TAG+"넘겨받은 내용은 "+notice.getContent());
		boardService.insert(notice);
		return "redirect:/notice/list";
	} 
	
	//목록을 처리하는 메서드
	@RequestMapping("/notice/list")
	public ModelAndView selectAll() {
		List list=null;
		list=boardService.selectAll();
		//list는 DispatcherServlet 대표 컨트롤러에게 전달되어야 한다..
		//따라서 list를 보관할 객체가 필요한데 스프링에서는 Model 객체가 
		//데이터를 보관하는 역할을 수행한다!!
		//사실 jsp에서의 RequestDispatcher 의 포워딩 기능과 같다 
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list); //list라는 이름으로 list를 보관
		mav.setViewName("notice/list");
		return mav;
	}
	
	//상세글 보기 요청을 처리 
	@RequestMapping("/notice/content")
	public ModelAndView select(@RequestParam("notice_id") int notice_id) {
		System.out.println("넘겨받은 notice_id는 "+notice_id);
		Notice notice=boardService.select(notice_id);
		
		ModelAndView mav = new ModelAndView("notice/content");
		mav.addObject("notice", notice);//결과 담기!!!
		System.out.println("제목은 "+notice.getTitle());
		return mav;
	}
}















