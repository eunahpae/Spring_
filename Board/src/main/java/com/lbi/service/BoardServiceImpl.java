package com.lbi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbi.mapper.BoardMapper;
import com.lbi.model.BoardVO;
import com.lbi.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper mapper;

	// �Խñ� ���
	@Override
	public void enroll(BoardVO board) {
		mapper.enroll(board);
	}

	// ��ü �Խñ� ��� ��ȸ
	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

	// Ư�� �Խñ� ��ȸ
	@Override
	public BoardVO getPage(int bno) {
		return mapper.getPage(bno);
	}

	// �Խñ� ����
	@Override
	public int modify(BoardVO board) {
		return mapper.modify(board);
	}

	// �Խñ� ����
	@Override
	public int delete(int bno) {
		return mapper.delete(bno);
	}

	// ����¡ ó���� �Խñ� ��� ��ȸ
	@Override
	public List<BoardVO> getListPaging(Criteria cri) {
		return mapper.getListPaging(cri);
	}

	// ��ü �Խñ� �� ��ȸ
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotal(cri);
	}

}
