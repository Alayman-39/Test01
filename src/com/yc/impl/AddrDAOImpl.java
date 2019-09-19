package com.yc.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.yc.commons.DbHelper;
import com.yc.dao.AddrDAO;
import com.yc.po.AddrPO;
public class AddrDAOImpl implements AddrDAO{

	DbHelper db = new DbHelper();
	@Override
	public List<AddrPO> find(AddrPO po) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select ano,mno,name,tel,province,city,area,addr from addrinfo where 1=1 ");
		List<Object> params = null;
		if(null!=po){
			params = new ArrayList<Object>();
			if(null!=po.getAno()){
				params.add(po.getAno());
				sb.append(" and ano = ? ");
			}else if(null!=po.getMno()){
				params.add(po.getMno());
				sb.append(" and mno = ? ");
			}
		}
		return db.findMutil(sb.toString(), params, AddrPO.class);
	}

	@Override
	public int add(AddrPO po) throws Exception {
		String sql = "insert into addrinfo values(null,?,?,?,?,?,?,?,2)";
		return db.update(sql, po.getMno(),po.getName(),po.getTel(),po.getProvince(),
				po.getCity(),po.getArea(),po.getAddr());
	}

	@Override
	public int update(AddrPO po) throws Exception {
		String sql = "udpate addrinfo set status = ? where ano = ? ";
		return db.update(sql, po.getStatus(),po.getAno());
	}

}
