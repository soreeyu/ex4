package com.choa.freeboard;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.ListInfo;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

@Service
public class FreeboardServiceImpl implements BoardService{

	@Inject
	private FreeboardDAOImpl freeboardDAO;
	
	
	@Override
	public List<BoardDTO> boardList(ListInfo listInfo) throws Exception {
		int result = freeboardDAO.boardCount(listInfo);
		
		listInfo.setRow();
		listInfo.makePage(result);
		
		return freeboardDAO.boardList(listInfo);
	}
	@Override
	public BoardDTO boardView(int num) throws Exception {
		return freeboardDAO.boardView(num);
	}
	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return freeboardDAO.boardWrite(boardDTO);
	}
	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return freeboardDAO.boardUpdate(boardDTO);
	}
	@Override
	public int boardDelete(int num) throws Exception {
		return freeboardDAO.boardDelete(num);
	}
	
}
