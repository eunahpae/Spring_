package com.lbi.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lbi.controller.BoardController;
import com.lbi.model.BoardVO;
import com.lbi.model.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTest {

	private static final Logger log = LoggerFactory.getLogger(BoardService.class);

	@Autowired
	private BoardService service;

	/*
	 * @Test public void testEnroll() { BoardVO vo = new BoardVO();
	 * 
	 * vo.setTitle("service test"); vo.setContent("service test");
	 * vo.setWriter("service test");
	 * 
	 * service.enroll(vo); }
	 * 
	 * @Test public void testGetList() { service.getList().forEach(board ->
	 * log.info("" + board)); }
	 * 
	 * @Test public void testGETPage() { int bno = 21; log.info("" +
	 * service.getPage(bno)); }
	 * 
	 * 
	 * @Test public void testModify() { BoardVO board = new BoardVO();
	 * board.setBno(21); board.setTitle("수정제목"); board.setContent("수정내용");
	 * 
	 * int result = service.modify(board); log.info("result : " + result); }
	 * 
	 * 
	 * @Test public void testDelete() { int result = service.delete(23);
	 * log.info("result : " + result); }
	 */
	
	@Test
	public void testGetListPaging() {

		Criteria cri = new Criteria();
		cri.setPageNum(2);
		List list = service.getListPaging(cri);
		list.forEach(board -> log.info("" + board));
	}
}
