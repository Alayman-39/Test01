package com.yc.dao;

import java.util.List;

import com.yc.po.TypeinfoPO;

public interface TypeinfoDAO {

	/**
	 * 浏览商品类型
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public List<TypeinfoPO> find(TypeinfoPO po) throws Exception;
}
