package com.yc.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yc.commons.DbHelper;
import com.yc.dao.OrderItemDAO;
import com.yc.po.OrderIteminfoPO;
import com.yc.vo.OrderItemVO;
import com.yc.vo.OrderVO;

public class OrderItemDAOImpl implements OrderItemDAO {

	DbHelper db = new DbHelper();

	@Override
	public List<OrderVO> find(OrderVO vo) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select g.*,o.* from orderiteminfo o inner join goodsinfo g on g.gno= o.gno where 1=1");
		List<Object> params = null;

		if (null != vo) {
			params = new ArrayList<Object>();

			if (null != vo.getTino()) {
				params.add(vo.getTino());
				sb.append("  and tino=? ");

			}
			if (null != vo.getGno()) {
				params.add(vo.getGno());
				sb.append("  and gno=? ");
			}
			if (null != vo.getOino()) {
				params.add(vo.getOino());
				sb.append("  and oino=?");
			}
			if (null != vo.getOno()) {
				params.add(vo.getOno());
				sb.append(" and ono= ? ");
			}
			if (null != vo.getStatus()) {
				sb.append("  and status= ?   ");
				params.add(vo.getStatus());
			}
		}
		sb.append(" order by oino");
		// TODO Auto-generated method stub
		return db.findMutil(sb.toString(), params, OrderVO.class);
	}

	@Override
	public int updateOrderItem(OrderIteminfoPO po) throws SQLException {
		String sql = "update orderiteminfo   set  ono=? ,status=2    where oino=?";

		// TODO Auto-generated method stub
		return db.update(sql, po.getOno(), po.getOino());
	}

	@Override
	public int addItem(OrderIteminfoPO po) throws Exception {
		String sql = " insert into orderiteminfo values(null,?,?,?,?,?,null,null,1)";
		return db.update(sql, po.getOno(), po.getGno(), po.getNum(), po.getOrprice(), po.getStatus());
	}

	@Override
	public List<OrderIteminfoPO> findByGno(OrderIteminfoPO po) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select oino,ono,gno,num,orprice,status,comments from orderiteminfo where 1=1");
		List<Object> params = null;
		if (null != po) {
			params = new ArrayList<Object>();
			if (null != po.getGno()) {
				params.add(po.getGno());
				sb.append(" and gno = ? ");
			}
			if (null != po.getOno()) {
				params.add(po.getOno());
				sb.append(" and ono = ? ");
			}
			if (null != po.getStatus()) {
				params.add(po.getStatus());
				sb.append(" and status = ? ");
			}

		}
		return db.findMutil(sb.toString(), params, OrderIteminfoPO.class);
	}

	@Override
	public int updateNum(OrderIteminfoPO po) throws Exception {
		String sql = "update orderiteminfo set num = num+ ? , orprice= orprice + ?  where gno = ?  and status=1";
		return db.update(sql, po.getNum(), po.getOrprice(), po.getGno());
	}

	@Override
	public int reduceNum(OrderIteminfoPO po) throws SQLException {
		String sql = "update  orderiteminfo  set  num=num-1 , orprice= orprice-? where oino= ? ";

		return db.update(sql, po.getOrprice(), po.getOino());
	}

	@Override
	public int addNum(OrderIteminfoPO po) throws SQLException {
		String sql = "update  orderiteminfo  set  num=num+1 , orprice= orprice+? where oino= ? ";

		// TODO Auto-generated method stub
		return db.update(sql, po.getOrprice(), po.getOino());
	}

	@Override
	public List<OrderItemVO> findAll(OrderItemVO vo) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select oi.*,o.* from orderinfo o inner join orderiteminfo oi on o.ono=oi.ono where 1=1 ");
		List<Object> params = null;

		if (null != vo) {
			params = new ArrayList<Object>();

			if (null != vo.getStatus()) {
				sb.append("  and o.status= ?   ");
				params.add(vo.getStatus());
			}

		}
		sb.append(" order by oino");
		// TODO Auto-generated method stub
		return db.findMutil(sb.toString(), params, OrderItemVO.class);
	}

}
