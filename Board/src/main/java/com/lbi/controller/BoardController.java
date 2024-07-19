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

	// �Խ��� ��� ������ ��û ó��
	@GetMapping("/list")
	private void boardListGet(Model model, Criteria cri) {
		// �α� ���: �Խ��� ��� ������ ����
		log.info("�Խ��� ��� ������ ����");

		// ���񽺸� ���� Criteria�� �´� �Խù� ��� ��������
		model.addAttribute("list", bservice.getListPaging(cri));

		// ��ü �Խù� �� ��ȸ
		int total = bservice.getTotal(cri);

		// ������ ���� ������ ���� PageMakerDTO ��ü ����
		PageMakerDTO pageMaker = new PageMakerDTO(cri, total);

		// �𵨿� ������ ���� ��ü �߰�
		model.addAttribute("pageMaker", pageMaker);
	}

	// �Խñ� ��� ������ ��û ó��
	@GetMapping("/enroll")
	private void boardEnrollGET() {
		// �α� ���: �Խ��� ��� ������ ����
		log.info("�Խ��� ��� ������ ����");
	}

	// �Խñ� ��� ó��
	@PostMapping("/enroll")
	private String boardEnrollPOST(BoardVO board, RedirectAttributes rttr) {
		// �α� ���: ��ϵ� �Խñ� ���� ���
		log.info("��ϵ� �Խñ� ����: " + board);

		// �Խñ� ��� ���� ȣ��
		bservice.enroll(board);

		// ��� ���� �޽����� Flash �Ӽ����� ����
		rttr.addFlashAttribute("result", "enroll success");

		// �Խ��� ��� �������� �����̷�Ʈ
		return "redirect:/board/list";
	}

	// �Խñ� ��ȸ ������ ��û ó��
	@GetMapping("/get")
	private void boardGetPageGET(int bno, Model model) {
		// �Խñ� �� ������ �𵨿� �߰�
		model.addAttribute("pageInfo", bservice.getPage(bno));
	}

	// �Խñ� ���� ������ ��û ó��
	@GetMapping("/modify")
	private void boardModifyGET(int bno, Model model) {
		// �Խñ� ������ ���� �� ������ �𵨿� �߰�
		model.addAttribute("pageInfo", bservice.getPage(bno));
	}

	// �Խñ� ���� ó��
	@PostMapping("/modify")
	private String boardModifyPOST(BoardVO board, RedirectAttributes rttr) {
		// �Խñ� ���� ���� ȣ��
		bservice.modify(board);

		// ���� ���� �޽����� Flash �Ӽ����� ����
		rttr.addFlashAttribute("result", "modify success");

		// �Խ��� ��� �������� �����̷�Ʈ
		return "redirect:/board/list";
	}

	// �Խñ� ���� ó��
	@PostMapping("/delete")
	private String boardDeletePOST(int bno, RedirectAttributes rttr) {
		// �Խñ� ���� ���� ȣ��
		bservice.delete(bno);

		// ���� ���� �޽����� Flash �Ӽ����� ����
		rttr.addFlashAttribute("result", "delete success");

		// �Խ��� ��� �������� �����̷�Ʈ
		return "redirect:/board/list";
	}

}
