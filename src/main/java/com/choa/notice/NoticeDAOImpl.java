package com.choa.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.board.BoardDAO;
import com.choa.board.BoardDTO;
import com.choa.util.DBConnect;
import com.choa.util.ListInfo;
import com.choa.util.RowMaker;

@Repository 
//NoticeDAO noticeDAO = new NoticeDAO();
public class NoticeDAOImpl implements BoardDAO{

	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE="NoticeMapper.";
	
	
	
	/*public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/
	

	
	public void boardHit(int num) throws Exception{
		Connection con = null;
		PreparedStatement st =null;
		int result =0;
		
		String sql ="update notice set hit=hit+1 where num=?";
		
		
			st = con.prepareStatement(sql);
			st.setInt(1, num);
			result = st.executeUpdate();
			
			DBConnect.disConnect(st, con);
		
	}
	

	


	@Override
	public List<BoardDTO> boardList(ListInfo listInfo) throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"list", listInfo);
	}

	@Override
	public BoardDTO boardView(int num) throws Exception {
		BoardDTO boardDTO=sqlSession.selectOne(NAMESPACE+"view", num); //NoticeMapper.view , returntype = T 는 mapper에 등록한 resultType 이다
															//인자값을 하나만 보내야됨
		return boardDTO;
	}

	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		int result = sqlSession.insert(NAMESPACE+"write", boardDTO);
		return result;
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"update", boardDTO);
	}

	@Override
	public int boardDelete(int num) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"delete", num);
	}
	@Override
	public int boardCount(ListInfo listInfo) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"count", listInfo);
	}
	
	
}
