package com.yc.test;

import org.junit.Test;

import com.yc.po.MemberPO;

public class MemberDAOImplTest {

	@Test
	public void testLogin() {
		MemberPO po = new MemberPO();
		po.setNickname("zj");
		po.setPwd("a");
		
	}

	@Test
	public void testRegister() {
		MemberPO po = new MemberPO();
		po.setNickname("yc");
		po.setPwd("a");
		po.setTel("13043637368");
		po.setEmail("932237228@qq.com");
	}

}
