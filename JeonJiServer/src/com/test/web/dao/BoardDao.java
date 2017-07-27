package com.test.web.dao;

import java.util.List;

import com.test.web.bean.BoardBean;

public interface BoardDao {
	
	public BoardBean selectBoard();
	
	public List<BoardBean> selectBoardList();
	
	public int insertBoard(BoardBean bean);
	public int updateBoard(BoardBean bean);
	public int deleteBoard(BoardBean bean);
}
