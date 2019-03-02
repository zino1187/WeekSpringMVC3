package test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class HelloController {
	
	//url ��û�� ó���� �޼��带 ������̼����� �����ؾ� �Ѵ�!!
	@RequestMapping("/hello")
	public ModelAndView test1() {
		//������ �信 ���� ������ ��Ƽ� �� �ܼ��� ��Ƽ� DispatcherServlet
		//���� ��ȯ�ؾ� �Ѵ�..
		//Model���� ������ ���(�ܹ���..)
		//View ���� � ���������� �������� �������� �ܼ�..
		ModelAndView mav = new ModelAndView();
		mav.addObject("food", "�ܹ���");//��û ��ü�� setAttribute()
		//���� ����������� �ڹ��ڵ忡 �ϵ��ڵ��� ������, ���� ����������
		//���� �ɰ�� �ش� Ŭ������ ��� �� �����ؾ� �Ѵ�..
		//������������ ��������..
		//�ذ�å?? ���ϸ��� ����������� ����, �ܼ���...
		mav.setViewName("food/result");		
		return mav;
	}

	
}







