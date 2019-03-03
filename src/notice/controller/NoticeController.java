//공지사항 게시판과 관련된 모든 요청을 처리하는 하위 컨트롤러
//공지사항과 관련된 요청: 글쓰기요청, 삭제요청, 리스트요청, 수정요청...
package notice.controller;

import org.springframework.web.bind.annotation.RequestMapping;

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
		return "notice/list";
	} 
	
	//목록을 처리하는 메서드
	public void selectAll() {
		
	}
}















