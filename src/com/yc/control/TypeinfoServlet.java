package com.yc.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.dao.TypeinfoDAO;
import com.yc.impl.TypeinfoDAOImpl;
import com.yc.po.TypeinfoPO;
@WebServlet("/Typeinfo.action")
public class TypeinfoServlet extends BaseServlet{

	/**
	 * 
	 */
	TypeinfoDAO dao = new TypeinfoDAOImpl();
	private static final long serialVersionUID = 7193930330798638716L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		String op = request.getParameter("op");
		 if("find".equals(op)){
			doFind(request,response);
		}
	}

	private void doFind(HttpServletRequest request, HttpServletResponse response) {
		TypeinfoPO po = parserRequestToObject(request, TypeinfoPO.class);
		try {
			List<TypeinfoPO> list = dao.find(po);
			toPrintString(response, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
