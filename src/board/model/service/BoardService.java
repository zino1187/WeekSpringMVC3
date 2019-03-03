/*
 * DAO간 트랜잭션 처리, 복합적 업무를 지휘할 모델 파트의 상위
 * 객체가 필요한데, 설계분야에서는 이러한 목적의 객체를 가리켜 
 * Service 이고, Service컨트롤러가 아닌 모델이다!!
 * */
package board.model.service;

import java.util.List;

import notice.model.Notice;

public interface BoardService {
	public void insert(Notice notice);
	public List selectAll();
}






