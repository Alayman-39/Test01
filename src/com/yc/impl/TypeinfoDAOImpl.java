package com.yc.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.commons.DbHelper;
import com.yc.dao.TypeinfoDAO;
import com.yc.po.TypeinfoPO;

public class TypeinfoDAOImpl implements TypeinfoDAO{

	DbHelper db = new DbHelper();
	@Override
	public List<TypeinfoPO> find(TypeinfoPO po) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select tno,tname,status from typeinfo where 1=1 ");
		List<Object> params = null;
		if(null!=po){
			params = new ArrayList<Object>();
			if(null!=po.getTno()){
				params.add(po.getTno());
				sb.append(" and tno = ? ");
			}
			if(null!=po.getTname()){
				params.add(po.getTname());
				sb.append(" and tname = ? ");
			}
			if(null!=po.getStatus()){
				params.add(po.getStatus());
				sb.append(" and status = ? ");
			}
		}
		sb.append(" order by tno asc ");
		return db.findMutil(sb.toString(), params, TypeinfoPO.class);
	}

}
