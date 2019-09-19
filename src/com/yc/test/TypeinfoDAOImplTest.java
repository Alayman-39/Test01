package com.yc.test;

import java.util.List;

import org.junit.Test;

import com.yc.dao.TypeinfoDAO;
import com.yc.impl.TypeinfoDAOImpl;
import com.yc.po.TypeinfoPO;

public class TypeinfoDAOImplTest {

	TypeinfoDAO dao = new TypeinfoDAOImpl();
	@Test
	public void testFind() throws Exception {
		TypeinfoPO po = new TypeinfoPO();
		po.setTname("新鲜水果");
		List<TypeinfoPO> list = dao.find(po);
		for(TypeinfoPO p:list){
			System.out.println(p.getStatus());
		}
		
	}

}
