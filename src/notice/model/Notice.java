package notice.model;
//이 클래스의 목적?? 로직을 처리하기 위함이 아닌 단순히 데이터를
//담아놓기 위한 용도로 정의 , 이러한 목적으로 정의된 객체를 가리켜
// DTO (Data Transfer Object) , VO(Value Object)
//DTO는 테이블의 레코드 1건을 담기 위한 용도이므로 테이블의 
//컬럼명과 일치시킨다!!
public class Notice {
	private int notice_id;
	private String title;
	private String writer;
	private String content;
	private String regdate;
	private int hit;
	
	public int getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
}












