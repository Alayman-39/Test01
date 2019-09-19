package com.yc.dao;

import java.util.List;

import com.yc.po.OrderinfoPO;
import com.yc.vo.OrderVO;

public interface OrderDAO {

	/**
	 * 下单
	 * @param oids
	 * @return
	 * @throws Exception
	 */
	public int UpdateOrderList(String [] oids)throws Exception;
	
	/**
	 * 分页查询
	 * @param vo
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<OrderVO> findByPage(OrderVO vo,Integer pageNum,Integer pageSize) throws Exception;
	
	/**
	 * 查询
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public List<OrderinfoPO> findAll(OrderinfoPO po) throws Exception;
	
	/**
	 * 增加订单
	 * @param po
	 * @return
	 * @throws Exception
	 */
	public int addOrder(OrderinfoPO po)throws Exception;
}
