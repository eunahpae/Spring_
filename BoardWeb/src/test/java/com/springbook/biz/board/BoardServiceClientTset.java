package com.springbook.biz.board;

import java.util.List;

import com.springbook.biz.board.impl.BoardDAO;

public class BoardServiceClientTset {
	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();

		BoardVO vo = new BoardVO();
		vo.setTitle("mybatis 제목");
		vo.setWriter("홍길동");
		vo.setContent("mybatis 내용입니다......");
		boardDAO.insertBoard(vo);

		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.println("-----> " + board.toString());
		}

	}
}
