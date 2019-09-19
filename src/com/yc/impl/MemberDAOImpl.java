package com.yc.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.commons.DbHelper;
import com.yc.dao.MemberinfoDAO;
import com.yc.po.MemberPO;

public class MemberDAOImpl implements MemberinfoDAO{

	DbHelper db = new DbHelper();
			
	@Override
	public MemberPO login(MemberPO po) throws Exception {
		String sql="select * from memberinfo where nickname=? and pwd = ? ";
		List<Object> params=new ArrayList<Object>();
		params.add(po.getNickname());
		params.add(po.getPwd());
		List<MemberPO> list=db.findMutil(sql, params,MemberPO.class);
		if(null!=list && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public int register(MemberPO po) throws Exception {
		String sql = "insert into memberinfo valuse(null,?,?,?,?,null,null,?,now(),1)";
		return db.update(sql,po.getNickname(),po.getPwd(),po.getTel(),
				po.getEmail(),po.getSex());
		
	}

	@Override
	public List<MemberPO> find(MemberPO po) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append(" select mno,nickname,pwd,tel,email,photo,realName,sex,regDate,status "
				+ " from memberinfo where 1=1 ");
		List<Object> params = null;
		if(null!=po){
			params=new ArrayList<Object>();
			if(null!=po.getMno()){
				params.add(po.getMno());
				sb.append(" and mno = ? ");
			}
			if(null!=po.getNickname()){
				params.add(po.getNickname());
				sb.append(" and nickname = ? ");
			}
			if(null!=po.getTel()){
				params.add(po.getTel());
				sb.append(" and tel = ? ");
			}
			if(null!=po.getEmail()){
				params.add(po.getEmail());
				sb.append(" and email = ? ");
			}
		}
		
		return db.findMutil(sb.toString(), params, MemberPO.class);
	}

}
