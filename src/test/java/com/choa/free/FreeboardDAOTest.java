package com.choa.free;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.choa.board.BoardDTO;
import com.choa.freeboard.FreeboardDAOImpl;
import com.choa.freeboard.FreeboardDTO;
import com.choa.notice.MyAbstractTest;

public class FreeboardDAOTest extends MyAbstractTest{

	@Inject
	private FreeboardDAOImpl freeboardDAOTest;
	
	@Test
	public void view() throws Exception {
		BoardDTO boardDTO  = freeboardDAOTest.boardView(5);
		System.out.println(boardDTO.getTitle());
	}

}
