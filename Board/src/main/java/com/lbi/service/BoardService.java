package com.lbi.service;

import java.util.List;

import com.lbi.model.BoardVO;
import com.lbi.model.Criteria;

public interface BoardService {
	
	// �Խñ� ���
	public void enroll(BoardVO board);
	
	// ��ü �Խñ� ��� ��ȸ
	public List<BoardVO> getList();
	
	// Ư�� �Խñ� ��ȸ
	public BoardVO getPage(int bno);
	
	// �Խñ� ����
	public int modify(BoardVO board);

	// �Խñ� ����
	public int delete(int bno);

	// ����¡ ó���� �Խñ� ��� ��ȸ
	public List<BoardVO> getListPaging(Criteria cri);
	
	// ��ü �Խñ� �� ��ȸ (�˻� ���ǿ� ����)
	public int getTotal(Criteria cri);

}
