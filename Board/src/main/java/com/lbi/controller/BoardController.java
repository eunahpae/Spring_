package com.lbi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lbi.model.BoardVO;
import com.lbi.model.Criteria;
import com.lbi.model.PageMakerDTO;
import com.lbi.service.BoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService bservice;

	// 게시판 목록 페이지 요청 처리
	@GetMapping("/list")
	private void boardListGet(Model model, Criteria cri) {
		// 로그 출력: 게시판 목록 페이지 진입
		log.info("게시판 목록 페이지 진입");

		// 서비스를 통해 Criteria에 맞는 게시물 목록 가져오기
		model.addAttribute("list", bservice.getListPaging(cri));

		// 전체 게시물 수 조회
		int total = bservice.getTotal(cri);

		// 페이지 정보 생성을 위한 PageMakerDTO 객체 생성
		PageMakerDTO pageMaker = new PageMakerDTO(cri, total);

		// 모델에 페이지 정보 객체 추가
		model.addAttribute("pageMaker", pageMaker);
	}

	// 게시글 등록 페이지 요청 처리
	@GetMapping("/enroll")
	private void boardEnrollGET() {
		// 로그 출력: 게시판 등록 페이지 진입
		log.info("게시판 등록 페이지 진입");
	}

	// 게시글 등록 처리
	@PostMapping("/enroll")
	private String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {
		// 로그 출력: 등록된 게시글 정보 출력
		log.info("등록된 게시글 정보: " + board);

		// 게시글 등록 서비스 호출
		bservice.enroll(board);

		// 등록 성공 메시지를 Flash 속성으로 전달
		rttr.addFlashAttribute("result", "enroll success");

		// 게시판 목록 페이지로 리다이렉트
		return "redirect:/board/list";
	}

	// 게시글 조회 페이지 요청 처리
	@GetMapping("/get")
	private void boardGetPageGET(int bno, Model model) {
		// 게시글 상세 정보를 모델에 추가
		model.addAttribute("pageInfo", bservice.getPage(bno));
	}

	// 게시글 수정 페이지 요청 처리
	@GetMapping("/modify")
	private void boardModifyGET(int bno, Model model) {
		// 게시글 수정을 위한 상세 정보를 모델에 추가
		model.addAttribute("pageInfo", bservice.getPage(bno));
	}

	// 게시글 수정 처리
	@PostMapping("/modify")
	private String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {
		// 게시글 수정 서비스 호출
		bservice.modify(board);

		// 수정 성공 메시지를 Flash 속성으로 전달
		rttr.addFlashAttribute("result", "modify success");

		// 게시판 목록 페이지로 리다이렉트
		return "redirect:/board/list";
	}

	// 게시글 삭제 처리
	@PostMapping("/delete")
	private String boardDeletePOST(int bno, RedirectAttributes rttr) {
		// 게시글 삭제 서비스 호출
		bservice.delete(bno);

		// 삭제 성공 메시지를 Flash 속성으로 전달
		rttr.addFlashAttribute("result", "delete success");

		// 게시판 목록 페이지로 리다이렉트
		return "redirect:/board/list";
	}

}
