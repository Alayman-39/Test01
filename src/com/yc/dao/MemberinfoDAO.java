package com.yc.dao;

import java.util.List;

import com.yc.po.MemberPO;

public interface MemberinfoDAO {

	/**
	 * 会员登陆
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public MemberPO login(MemberPO po)throws Exception;
	
	/**
	 * 会员注册
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public int register(MemberPO po)throws Exception;
	
	/**
	 * 
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public List<MemberPO> find(MemberPO po)throws Exception;
}
