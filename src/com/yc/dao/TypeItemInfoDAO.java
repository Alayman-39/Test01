package com.yc.dao;

import java.util.List;

import com.yc.po.TypeIteminfoPO;
import com.yc.vo.TypeItemVO;

public interface TypeItemInfoDAO {

	
	public List<TypeItemVO> findByType(TypeItemVO vo) throws Exception;
	
	/**
	 * 添加
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public int addTypeIteminfo(TypeIteminfoPO po)throws Exception;
	
	/**
	 * 分页查询
	 * @param po
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<TypeIteminfoPO> findByPage(TypeIteminfoPO po,Integer pageNum,Integer pageSize)throws Exception;
	
	/**
	 * 分页总条数
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public int totalPage(TypeIteminfoPO po)throws Exception;
	
	/**
	 * 浏览商品类型
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public List<TypeIteminfoPO> find(TypeIteminfoPO po) throws Exception;
}
