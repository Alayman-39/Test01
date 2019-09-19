package com.yc.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.commons.DbHelper;
import com.yc.dao.TypeItemInfoDAO;
import com.yc.po.TypeIteminfoPO;
import com.yc.vo.TypeItemVO;

public class TypeIteminfoDAOImpl implements TypeItemInfoDAO{

	DbHelper db = new DbHelper();
	@Override
	public List<TypeItemVO> findByType(TypeItemVO vo) throws Exception {
		StringBuffer  sb = new StringBuffer();
		sb.append(" select t.*,i.* from typeinfo t inner join typeiteminfo i on t.tno=i.tno where i.tno=? ");
		List<Object> params= null;
		if(null!=vo){
			params = new ArrayList<Object>();
			if(null!=vo.getTno()){
				params.add(vo.getTno());
				sb.append(" and tno = ? ");
			}else if(null!=vo.getTino()){
				params.add(vo.getTino());
				sb.append(" and tino = ? ");
			}
		}
		sb.append(" group by tno ");
		return db.findMutil(sb.toString(), params, TypeItemVO.class);
	}

	@Override
	public List<TypeIteminfoPO> find(TypeIteminfoPO po) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select gno,gname,tino,price,intro,balance,unit,place,qualityPeriod,"
				+ "weight,pics,descr from goodsinfo  where 1=1 ");
		List<Object> params = null;
		if(null!=po){
			params = new ArrayList<Object>();
			if(null!=po.getTino()){
				params.add(po.getTino());
				sb.append(" and tino = ? ");
			}else if(null!=po.getTname()){
				params.add(po.getTname());
				sb.append(" and tname = ? ");
			}else if(null!=po.getTno()){
				params.add(po.getTno());
				sb.append(" and tno = ? ");
			}else if(null!=po.getStatus()){
				params.add(po.getStatus());
				sb.append(" and status = ? ");
			}
		}
		sb.append(" order by tino asc ");		
		return db.findMutil(sb.toString(), params, TypeIteminfoPO.class);
	}
	
	@Override
	public int addTypeIteminfo(TypeIteminfoPO po) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TypeIteminfoPO> findByPage(TypeIteminfoPO po, Integer pageNum, Integer pageSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int totalPage(TypeIteminfoPO po) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
