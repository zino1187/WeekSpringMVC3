package db;
//어떨때는 , 특정 객체의 인스턴스를 두개이상 허용하면 않되는 경우가 있다.
//우리의 경우 커넥션풀임...
//즉 외부의 있는 어떤 클래스가 특정 클래스의 인스턴스를 맘대로 new 할수
//없도록 개발자가 제한을 가할수 있다??? 있다..
//GOF(Gang of four : 애칭) 
//전세계 모든 개발자들이 코드작성 습관, 패턴..각 패턴마다 이름을 붙임..
//전산 역사에 큰 획을 그음...
//왜?? 용어를 통일...
// GOF가 명시한 총 20여가지의 패넌 중 하나인 싱글턴은 
//"특정 객체의 인스턴스를 단 1개만 허용하는 개발패턴을 의미" 
public class UsePool {
	public static void main(String[] args) {
		PoolManager pool1 = PoolManager.getInstance();
		PoolManager pool2 = PoolManager.getInstance();
		PoolManager pool3 = PoolManager.getInstance();
		PoolManager pool4 = PoolManager.getInstance();
		System.out.println(pool1);
		System.out.println(pool2);
		System.out.println(pool3);
		System.out.println(pool4);
	}
}













