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

import com.test.web.dao.MemberDao;
import com.test.web.bean.BoardBean;
import com.test.web.bean.MemberBean;

@Controller
public class WowController {
	
	@Autowired
	private MemberDao memberDao;

	// db--> bean--> json
	@RequestMapping("wow/selectMember")
	@ResponseBody
	public Map<String, Object> selectMember(MemberBean mBean)	{
		
		Map<String, Object> resMap = new HashMap<String, Object>();
		
		try	{
		MemberBean resBean = memberDao.selectMember(mBean);
		
		resMap.put("result", "ok");
		resMap.put("MemberBean", resBean);
		} catch	(Exception e){
		e.printStackTrace();
		resMap.put("result", "fail");
		}
		return resMap;

	}
	
	
	// db--> bean--> json
			@RequestMapping("wow/selectMemberList")
			@ResponseBody
			public Map<String, Object> selectMemberList()	{
				
				Map<String, Object> resMap = new HashMap<String, Object>();
				
				try	{
				
				List<MemberBean> list = memberDao.selectMemberList();
				
				resMap.put("result", "ok");
				resMap.put("memberList", list);
				} catch	(Exception e){
				e.printStackTrace();
				resMap.put("result", "fail");
				}
				return resMap;

			}

		
		// db--> bean--> json
				@RequestMapping("wow/insertMember")
				@ResponseBody
				public Map<String, Object> insertMember(MemberBean mBean)	{
					
					Map<String, Object> resMap = new HashMap<String, Object>();
					resMap.put("result", "fail");
					
					try	{
						int resVal = memberDao.insertMember(mBean);
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
				@RequestMapping("wow/updateMember")
				@ResponseBody
				public Map<String, Object> updateMember(MemberBean mBean)	{
					
					Map<String, Object> resMap = new HashMap<String, Object>();
					resMap.put("result", "fail");
					
					try	{
						int resVal = memberDao.updateMember(mBean);
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
				@RequestMapping("wow/deleteMember")
				@ResponseBody
				public Map<String, Object> deleteMember(MemberBean mBean)	{
					
					Map<String, Object> resMap = new HashMap<String, Object>();
					resMap.put("result", "fail");
					
					try	{
						int resVal = memberDao.deleteMember(mBean);
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