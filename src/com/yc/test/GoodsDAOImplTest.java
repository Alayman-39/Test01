package com.yc.test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.yc.commons.DbHelper;
import com.yc.dao.GoodsinfoDAO;
import com.yc.impl.GoodsDAOImpl;
import com.yc.po.GoodsPO;

public class GoodsDAOImplTest {

	DbHelper db = new DbHelper();
	GoodsinfoDAO dao = new GoodsDAOImpl();
	@Test
	public void testAddGoods() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testTotalPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindRand() throws SQLException {
		System.out.println(db.getConn().getClass().getName());
	}
	
	@Test
	public void testFind() throws Exception {
		GoodsPO po = new GoodsPO();
		po.setGname("草莓");
		List<GoodsPO> list = dao.find(po); 
		for (GoodsPO p : list) {
			System.out.println(p.getIntro());
		}
	}

}
