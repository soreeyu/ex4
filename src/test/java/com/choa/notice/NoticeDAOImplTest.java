package com.choa.notice;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.choa.board.BoardDTO;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

public class NoticeDAOImplTest extends MyAbstractTest{

	@Inject
	private NoticeDAOImpl noticeDAOImpl;
	
	
	public void connectionTest() throws Exception{
		BoardDTO boardDTO=noticeDAOImpl.boardView(342);
		assertNotNull(boardDTO);
		System.out.println(boardDTO.getTitle());
	}
	
	
	public void insert() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setWriter("choa");
		noticeDTO.setTitle("tetst");
		noticeDTO.setContents("DODNEOE");
		int result = noticeDAOImpl.boardWrite(noticeDTO);
		System.out.println(result);
		assertEquals(1, result);
	}
	
	
	public void update() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(420);
		noticeDTO.setTitle("choachoa");
		noticeDTO.setContents("IUIUIUIUIUIUI");
		int result = noticeDAOImpl.boardUpdate(noticeDTO);
		System.out.println(result);
		assertEquals(1, result);
	}
	
	
	public void delete() throws Exception{
		int result = noticeDAOImpl.boardDelete(420);
		assertEquals(1, result);
	}
	
	
	public void list() throws Exception{
		PageMaker pageMaker = new PageMaker(1);
		RowMaker rowMaker = pageMaker.getRowMaker();
		List<BoardDTO> ar = noticeDAOImpl.boardList(rowMaker);
		
		System.out.println(ar.size());
	}
	
	@Test
	public void count() throws Exception{
		
		int result = noticeDAOImpl.boardCount();
		System.out.println(result);
	}

}
