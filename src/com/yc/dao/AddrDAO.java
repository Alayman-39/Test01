package com.yc.dao;

import java.util.List;

import com.yc.po.AddrPO;

public interface AddrDAO {
	
	/**
	 * 查询
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public List<AddrPO> find(AddrPO po) throws Exception;
	
	/**
	 * 添加
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public int add(AddrPO po) throws Exception;

	public int update(AddrPO po) throws Exception;
}
