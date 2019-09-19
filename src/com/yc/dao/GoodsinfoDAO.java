package com.yc.dao;

import java.util.List;

import com.yc.po.GoodsPO;
import com.yc.vo.GoodsVO;

public interface GoodsinfoDAO {

	/**
	 * 获取
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public List<GoodsPO> find(GoodsPO po) throws Exception;
	
	
	/**
	 * 添加商品信息
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public int addGoods(GoodsPO po) throws Exception;
	
	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public List<GoodsVO> findByPage(GoodsVO vo, Integer pageNum, Integer pageSize)throws Exception;
	
	/**
	 * 分页总条数
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public int totalPage(GoodsVO vo) throws Exception;
	
	/**
	 * 随机查询促销产品
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public List<GoodsPO> findRand()throws Exception;
}
