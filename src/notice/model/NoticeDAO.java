package notice.model;

import java.util.List;

//Pan과 같다
//인터페이스는 하위객체들이 구현해야할 메서드를 몸체없는 추상메서드로 정의해
//놓은 객체이다!!
public interface NoticeDAO {
	public int insert(Notice notice);
	public List selectAll();
}







