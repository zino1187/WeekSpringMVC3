package db;
//����� , Ư�� ��ü�� �ν��Ͻ��� �ΰ��̻� ����ϸ� �ʵǴ� ��찡 �ִ�.
//�츮�� ��� Ŀ�ؼ�Ǯ��...
//�� �ܺ��� �ִ� � Ŭ������ Ư�� Ŭ������ �ν��Ͻ��� ����� new �Ҽ�
//������ �����ڰ� ������ ���Ҽ� �ִ�??? �ִ�..
//GOF(Gang of four : ��Ī) 
//������ ��� �����ڵ��� �ڵ��ۼ� ����, ����..�� ���ϸ��� �̸��� ����..
//���� ���翡 ū ȹ�� ����...
//��?? �� ����...
// GOF�� ����� �� 20�������� �г� �� �ϳ��� �̱����� 
//"Ư�� ��ü�� �ν��Ͻ��� �� 1���� ����ϴ� ���������� �ǹ�" 
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













