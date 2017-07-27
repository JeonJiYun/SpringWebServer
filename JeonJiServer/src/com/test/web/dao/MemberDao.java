package com.test.web.dao;

import java.util.List;

import com.test.web.bean.BoardBean;
import com.test.web.bean.MemberBean;

public interface MemberDao {
	
	public MemberBean selectMember(MemberBean bean);
	
	public List<MemberBean> selectMemberList();
	
	public int insertMember(MemberBean bean);
	public int updateMember(MemberBean bean);
	public int deleteMember(MemberBean bean);
	
	public MemberBean loginProc(MemberBean bean);
}
