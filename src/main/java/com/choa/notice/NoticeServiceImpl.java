package com.choa.notice;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.ListInfo;
import com.choa.util.MakePage;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;


@Service
//NoticeService noticeService = new NoticeService();
public class NoticeServiceImpl implements BoardService{

	@Inject
	private NoticeDAOImpl noticeDAO;
	
	public void test(){
		System.out.println(noticeDAO);
	}
	
	
	/*public NoticeService(){
		
	}
	
	//Constructor 생성자
	public NoticeService(NoticeDAO noticeDAO){
		this.noticeDAO = noticeDAO;
	}
	
	//setter
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}*/
	


	@Override
	public List<BoardDTO> boardList(ListInfo listInfo) throws Exception {
		int result = noticeDAO.boardCount(listInfo);
		listInfo.setRow();
		listInfo.makePage(result);
		
		return noticeDAO.boardList(listInfo);
	}


	@Override
	public BoardDTO boardView(int num) throws Exception {
		return noticeDAO.boardView(num);
	}


	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardWrite(boardDTO);
	}


	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAO.boardUpdate(boardDTO);
	}


	@Override
	public int boardDelete(int num) throws Exception {
		return noticeDAO.boardDelete(num);
	}
	
	
}
