package com.lbi.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lbi.model.BoardVO;
import com.lbi.model.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTest {

	private final static Logger log = LoggerFactory.getLogger(BoardMapperTest.class);

	@Autowired
	private BoardMapper mapper;

	/*
	 * @Test public void testEnroll() { BoardVO vo = new BoardVO();
	 * vo.setTitle("mapper test"); vo.setContent("mapper test");
	 * vo.setWriter("mapper test"); mapper.enroll(vo); }
	 * 
	 * @Test public void testGetList() { List list = mapper.getList();
	 * 
	 * for (int i = 0; i < list.size(); i++) { log.info("" + list.get(i)); }
	 * 
	 * for (Object a : list) { log.info("" + a); }
	 * 
	 * list.forEach(board -> log.info("" + board)); }
	 * 
	 * @Test public void testGetPage() { int bno = 21;
	 * 
	 * log.info("" + mapper.getPage(bno));
	 * 
	 * }
	 * 
	 * @Test public void testModify() { BoardVO board = new BoardVO();
	 * board.setBno(21); board.setTitle("수정제목"); board.setContent("수정내용");
	 * 
	 * int result = mapper.modify(board); log.info("result : " + result); }
	 * 
	 * 
	 * @Test public void testDelete() { int result = mapper.delete(23);
	 * log.info("result : " + result); }
	 * 
	 */
	
	@Test
	public void testGetListPaging() {

		Criteria cri = new Criteria();
		cri.setPageNum(2);
		List list = mapper.getListPaging(cri);
		list.forEach(board -> log.info("" + board));
	}

}
