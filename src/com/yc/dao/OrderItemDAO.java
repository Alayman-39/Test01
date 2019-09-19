package com.yc.dao;

import java.sql.SQLException;
import java.util.List;

import com.yc.po.OrderIteminfoPO;
import com.yc.vo.OrderItemVO;
import com.yc.vo.OrderVO;

public interface OrderItemDAO {

	public List<OrderVO> find(OrderVO vo) throws Exception;

	public int updateOrderItem(OrderIteminfoPO po) throws SQLException;

	public int addItem(OrderIteminfoPO po) throws Exception;

	public List<OrderIteminfoPO> findByGno(OrderIteminfoPO po) throws Exception;

	public int updateNum(OrderIteminfoPO po) throws Exception;

	public int reduceNum(OrderIteminfoPO po) throws SQLException;

	public int addNum(OrderIteminfoPO po) throws SQLException;

	public List<OrderItemVO> findAll(OrderItemVO vo) throws Exception;
}
