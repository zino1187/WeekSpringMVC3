/*
 * DAO�� Ʈ����� ó��, ������ ������ ������ �� ��Ʈ�� ����
 * ��ü�� �ʿ��ѵ�, ����о߿����� �̷��� ������ ��ü�� ������ 
 * Service �̰�, Service��Ʈ�ѷ��� �ƴ� ���̴�!!
 * */
package board.model.service;

import java.util.List;

import notice.model.Notice;

public interface BoardService {
	public void insert(Notice notice);
	public List selectAll();
}






