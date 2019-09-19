package com.yc.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.commons.DbHelper;
import com.yc.dao.OrderDAO;
import com.yc.po.OrderinfoPO;
import com.yc.vo.OrderVO;

public class OrderDAOImpl implements OrderDAO{

	DbHelper db = new DbHelper();
	@Override
	public int UpdateOrderList(String[] oids) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<OrderVO> findByPage(OrderVO vo, Integer pageNum, Integer pageSize) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select t.*,i.* from typeinfo t inner join typeiteminfo i on t.tno=i.tno where 1=1 ");
		List<Object> params = null;
		if(null!=vo){
			params = new ArrayList<Object>();
			if(null!=vo.getGno()){
				params.add(vo.getGno());
				sb.append(" and gno = ? ");
			}if(null!=vo.getOino()){
				params.add(vo.getOino());
				sb.append(" and oino = ? ");
			}
		}
		if(null!=pageSize && null!=pageNum){
			sb.append(" limit "+(pageNum-1)*pageSize+","+pageSize);
		}
		sb.append(" order by  ");
		return db.findMutil(sb.toString(), params, OrderVO.class);
	}

	@Override
	public List<OrderinfoPO> findAll(OrderinfoPO po) throws Exception {
		String sql = "select * from orderinfo order by ono desc";
		return db.findMutil(sql, null, OrderinfoPO.class);
	}

	@Override
	public int addOrder(OrderinfoPO po) throws Exception {
		String sql = "insert into orderinfo values(?,now(),?,?,1,null,null,?,1,null,null,null,null)";
		return db.update(sql, po.getOno(),po.getAno(),po.getPrice(),po.getPno());
	}

}
