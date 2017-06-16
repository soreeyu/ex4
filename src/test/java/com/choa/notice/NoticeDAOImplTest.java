package com.choa.notice;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.choa.board.BoardDTO;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

public class NoticeDAOImplTest extends MyAbstractTest{

	@Inject
	private NoticeDAOImpl noticeDAO;
	
	@Test
	public void test() throws Exception{
		PageMaker pageMaker = new PageMaker(1);
		RowMaker rowMaker = pageMaker.getRowMaker();
		List<BoardDTO> ar =noticeDAO.boardList(rowMaker);
		assertEquals(10, ar.size());
	}
	
	@Test
	public void test2() throws Exception{
		int result =noticeDAO.boardDelete(22);
		
		assertEquals(1, result);
	}

}
