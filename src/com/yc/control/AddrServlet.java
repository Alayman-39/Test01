package com.yc.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.dao.AddrDAO;
import com.yc.impl.AddrDAOImpl;
import com.yc.po.AddrPO;
import com.yc.po.MemberPO;
@WebServlet("/addr.action")
public class AddrServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5030072258782036831L;
	AddrDAO dao = new AddrDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("find".equals(op)) {
			doFind(request, response);
		}else if("add".equals(op)){
			doAdd(request,response);
		}else if("update".equals(op)){
			doUpdate(request,response);
		}
	}

	private void doUpdate(HttpServletRequest request, HttpServletResponse response) {
		AddrPO po = parserRequestToObject(request, AddrPO.class);
		try {
			int list = dao.update(po);
			toPrintString(response, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doAdd(HttpServletRequest request, HttpServletResponse response) {
		AddrPO po = parserRequestToObject(request, AddrPO.class);
		try {
			int i = dao.add(po);
			System.out.println(i);
			System.out.println(po.getAddr()+"---"+po.getName());
			toPrintString(response, i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	private void doFind(HttpServletRequest request, HttpServletResponse response) {
		MemberPO  member = parserRequestToObject(request, MemberPO.class);
		AddrPO po = new AddrPO();
		po.setMno(member.getMno());
		try {
			List<AddrPO> list = dao.find(po);
			toPrintString(response, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
