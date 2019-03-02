package test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class HelloController {
	
	//url 요청을 처리할 메서드를 어노테이션으로 지정해야 한다!!
	@RequestMapping("/hello")
	public ModelAndView test1() {
		//보여줄 뷰에 대한 정보를 담아서 즉 단서를 담아서 DispatcherServlet
		//에게 반환해야 한다..
		//Model에는 정보를 담고(햄버거..)
		//View 에는 어떤 뷰페이지를 보여줄지 결정짓는 단서..
		ModelAndView mav = new ModelAndView();
		mav.addObject("food", "햄버거");//요청 객체에 setAttribute()
		//실제 결과페이지를 자바코드에 하드코딩해 놓으면, 추후 페이지명이
		//변경 될경우 해당 클래스를 열어서 또 수정해야 한다..
		//유지보수성이 떨어진다..
		//해결책?? 파일명을 직접명시하지 말고, 단서만...
		mav.setViewName("food/result");		
		return mav;
	}

	
}







