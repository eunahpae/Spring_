package com.lbi.service;

import java.util.List;

import com.lbi.model.BoardVO;
import com.lbi.model.Criteria;

public interface BoardService {
	
	// 게시글 등록
	public void enroll(BoardVO board);
	
	// 전체 게시글 목록 조회
	public List<BoardVO> getList();
	
	// 특정 게시글 조회
	public BoardVO getPage(int bno);
	
	// 게시글 수정
	public int modify(BoardVO board);

	// 게시글 삭제
	public int delete(int bno);

	// 페이징 처리된 게시글 목록 조회
	public List<BoardVO> getListPaging(Criteria cri);
	
	// 전체 게시글 수 조회 (검색 조건에 따른)
	public int getTotal(Criteria cri);

}
