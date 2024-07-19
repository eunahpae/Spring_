package com.lbi.mapper;

import java.util.List;

import com.lbi.model.BoardVO;
import com.lbi.model.Criteria;

public interface BoardMapper {
	
	// �Խù� ���
	public void enroll(BoardVO board);

	// �Խù� ��ȸ
	public List<BoardVO> getList();
	
	// �Խù� �� ��ȸ
	public BoardVO getPage(int bno);

	// �Խù� ����
	public int modify(BoardVO board);

	// �Խù� ����
	public int delete(int bno);

	// �Խù� ���(����¡ ����)
	public List<BoardVO> getListPaging(Criteria cri);

	// �Խù� �� ����
	public int getTotal(Criteria cri);
}
