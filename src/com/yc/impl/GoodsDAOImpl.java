package com.yc.impl;

import java.util.ArrayList;
import java.util.List;

import com.yc.commons.DbHelper;
import com.yc.dao.GoodsinfoDAO;
import com.yc.po.GoodsPO;
import com.yc.vo.GoodsVO;

public class GoodsDAOImpl implements GoodsinfoDAO {

	DbHelper db = new DbHelper();

	@Override
	public int addGoods(GoodsPO po) throws Exception {
		String sql = "insert into goodsinfo values(null,?,?,?,?,?,?,?,?,?,?,?)";
		return db.update(sql, po.getGname(), po.getTino(), po.getPrice(), po.getIntro(), po.getBalance(), po.getUnit(),
				po.getPlace(), po.getQualityPeriod(), po.getWeight(), po.getPics(), po.getDescr());
	}

	public List<GoodsVO> findByPage(GoodsVO vo, Integer pageNum, Integer pageSize) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select gno,gname,t.tino,price,intro,balance,unit,place,"
				+ " qualityPeriod,weight,pics,descr,tno,tname,status from goodsinfo"
				+ " g inner join typeiteminfo t on g.tino=t.tino where 1=1");
		List<Object> params = null;
		if (null != vo) {
			params = new ArrayList<Object>();
			if (null != vo.getGno()) {
				params.add(vo.getGno());
				sb.append(" and gno=?");
			}
			if (null != vo.getTino()) {
				params.add(vo.getTino());
				sb.append(" and t.tino=?");
			}
			if (null != vo.getGname()) {
				params.add(vo.getGname());
				sb.append(" and gname=?");
			}
			if (null != vo.getTno()) {
				params.add(vo.getTno());
				sb.append(" and tno=?");
			}
		}
		sb.append(" order by gno asc ");
		if (null != pageSize && null != pageNum) {
			sb.append(" limit " + (pageNum - 1) * pageSize + "," + pageSize);
		}
		// System.out.println(sb.toString());
		return db.findMutil(sb.toString(), params, GoodsVO.class);
	}

	@Override
	public int totalPage(GoodsVO vo) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(*) from goodsinfo g inner join typeiteminfo t on g.tino=t.tino where 1=1 ");
		List<Object> params = null;
		if (null != vo) {
			params = new ArrayList<Object>();
			if (null != vo.getTino()) {
				params.add(vo.getTino());
				sb.append(" and tino=?");
			}
			if (null != vo.getGname()) {
				params.add(vo.getGname());
				sb.append(" and gname=?");
			}
			if (null != vo.getTno()) {
				params.add(vo.getTno());
				sb.append(" and tno=?");
			}
		}
		return (int) db.getPromer(sb.toString(), params);
	}

	@Override
	public List<GoodsPO> findRand() throws Exception {
		String sql = "select * from goodsinfo where qualityPeriod between "
				+ " date_sub(now(),interval 5 DAY) and now() order by rand() limit 5";
		return db.findMutil(sql, null, GoodsPO.class);
	}

	@Override
	public List<GoodsPO> find(GoodsPO po) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("select gno,gname,tino,price,intro,balance,unit,place,qualityPeriod,"
				+ "weight,pics,descr from goodsinfo  where 1=1 ");
		List<Object> params = null;
		if (null != po) {
			params = new ArrayList<Object>();
			if (null != po.getGno()) {
				params.add(po.getGno());
				sb.append(" and gno = ? ");
			} else if (null != po.getGname()) {
				params.add(po.getGname());
				sb.append(" and gname = ? ");
			} else if (null != po.getTino()) {
				params.add(po.getTino());
				sb.append(" and tino = ? ");
			} else if (null != po.getPrice()) {
				params.add(po.getPrice());
				sb.append(" and price = ? ");
			} else if (null != po.getIntro()) {
				params.add(po.getIntro());
				sb.append(" and intro = ? ");
			} else if (null != po.getBalance()) {
				params.add(po.getBalance());
				sb.append(" and balance = ? ");
			} else if (null != po.getUnit()) {
				params.add(po.getUnit());
				sb.append(" and unit = ? ");
			} else if (null != po.getPlace()) {
				params.add(po.getPlace());
				sb.append(" and place = ? ");
			} else if (null != po.getQualityPeriod()) {
				params.add(po.getQualityPeriod());
				sb.append(" and qualityPeriod = ? ");
			} else if (null != po.getWeight()) {
				params.add(po.getWeight());
				sb.append(" and weight = ? ");
			} else if (null != po.getPics()) {
				params.add(po.getPics());
				sb.append(" and pics = ? ");
			} else if (null != po.getDescr()) {
				params.add(po.getDescr());
				sb.append(" and descr = ? ");
			}
		}
		sb.append(" order by gno asc ");
		return db.findMutil(sb.toString(), params, GoodsPO.class);
	}
}
