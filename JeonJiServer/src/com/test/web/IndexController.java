package com.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.web.bean.MemberBean;
import com.test.web.bean.TestBean;
import com.test.web.dao.*;
import com.test.web.bean.BoardBean;

@Controller
public class IndexController {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BoardDao boardDao;
	
	@RequestMapping("/hi/hello")
	public String hiWorld(String id, String pw)	{
		
		System.out.println("Id : " + id + ", pw : " + pw);
		
		return "hiWorld";
	}
	
	@RequestMapping("/hi/hello2")
	public String test2(TestBean tBean)	{
		//System.out.println("id : " + tBean.getId() + " pw : "+ tBean.getPw() + " add : " + tBean.getAddr());
		
		/*MemberBean memberBean = memberDao.selectMember();
		
		System.out.println("USER_ID : " + memberBean.getUserId());
		System.out.println("USER_PW : " + memberBean.getUserPw());
		System.out.println("USER_NAME : " + memberBean.getUserName()); */
		
		BoardBean boardBean = boardDao.selectBoard();
		
		System.out.println("BOARD_ID : " + boardBean.getBoardId());
		System.out.println("BOARD_TITLE : " + boardBean.getBoardTitle());
		System.out.println("BOARD_CONENT : " + boardBean.getBoardContent());
		System.out.println("BOARD_REG_DATE : " + boardBean.getBoardRegDate());
		System.out.println("BOARD_USER_ID : " + boardBean.getBoardUserId());
		
		
		
		return "hiWorld";
	}

}
