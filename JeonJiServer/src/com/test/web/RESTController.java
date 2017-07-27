package com.test.web;

import java.util.List;
import java.util.DuplicateFormatFlagsException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.web.dao.BoardDao;
import com.test.web.bean.BoardBean;

@Controller
public class RESTController {
	
	@Autowired
	private BoardDao boardDao;
	
	// db--> bean--> json
	@RequestMapping("rest/selectBoard")
	@ResponseBody
	public Map<String, Object> selectBoard()	{
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		try	{
		BoardBean mBean = boardDao.selectBoard();
		
		resMap.put("result", "ok");
		resMap.put("BoardBean", mBean);
		} catch	(Exception e){
		e.printStackTrace();
		resMap.put("result", "fail");
		}
		return resMap;

	}
	
	// db--> bean--> json
		@RequestMapping("rest/selectBoardList")
		@ResponseBody
		public Map<String, Object> selectBoardList()	{
			
			Map<String, Object> resMap = new HashMap<String, Object>();
			
			try	{
			
			List<BoardBean> list = boardDao.selectBoardList();
			
			resMap.put("result", "ok");
			resMap.put("BoardList", list);
			} catch	(Exception e){
			e.printStackTrace();
			resMap.put("result", "fail");
			}
			return resMap;

		}
		
		// db--> bean--> json
				@RequestMapping("rest/insertBoard")
				@ResponseBody
				public Map<String, Object> insertBoard(BoardBean mBean)	{
					
					Map<String, Object> resMap = new HashMap<String, Object>();
					resMap.put("result", "fail");
					
					try	{
						int resVal = boardDao.insertBoard(mBean);
						if(resVal>0){
							resMap.put("result", "ok");
						}
						
					}	catch (DuplicateKeyException dke)	{
						
						resMap.put("ressultMsg", "이미 존재하는 user_ID입니다");
					}
					catch	(Exception e){
					e.printStackTrace();
					
					}
					return resMap;

				}

				
				// db--> bean--> json
				@RequestMapping("rest/updateBoard")
				@ResponseBody
				public Map<String, Object> updateBoard(BoardBean mBean)	{
					
					Map<String, Object> resMap = new HashMap<String, Object>();
					resMap.put("result", "fail");
					
					try	{
						int resVal = boardDao.updateBoard(mBean);
						if(resVal>0){
							resMap.put("result", "ok");
							resMap.put("resultMsg", "업데이트에 성공하였습니다");
						}
						
					}	catch (DuplicateKeyException dke)	{
						
						resMap.put("ressultMsg", "존재하지 않는 user_ID입니다");
					}
					catch	(Exception e){
					e.printStackTrace();
					
					}
					return resMap;

				}
				
				// db--> bean--> json
				@RequestMapping("rest/deleteBoard")
				@ResponseBody
				public Map<String, Object> deleteBoard(BoardBean mBean)	{
					
					Map<String, Object> resMap = new HashMap<String, Object>();
					resMap.put("result", "fail");
					
					try	{
						int resVal = boardDao.deleteBoard(mBean);
						if(resVal>0){
							resMap.put("result", "ok");
							resMap.put("resultMsg", "업데이트에 성공하였습니다");
						}
						
					}	catch (DuplicateKeyException dke)	{
						
						resMap.put("ressultMsg", "존재하지 않는 user_ID입니다");
					}
					catch	(Exception e){
					e.printStackTrace();
					
					}
					return resMap;

				}
	
}