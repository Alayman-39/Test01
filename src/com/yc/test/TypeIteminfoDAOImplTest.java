package com.yc.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.yc.dao.TypeItemInfoDAO;
import com.yc.impl.TypeIteminfoDAOImpl;
import com.yc.po.TypeIteminfoPO;

public class TypeIteminfoDAOImplTest {

	TypeItemInfoDAO dao = new TypeIteminfoDAOImpl();
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddTypeIteminfo() {
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
	public void testFind() throws Exception {
	TypeIteminfoPO po = new TypeIteminfoPO();
	po.setTname("香蕉");
	List<TypeIteminfoPO> list = dao.find(po);
	for(TypeIteminfoPO p:list){
		System.out.println(p.getTino());
	}
	}

}
