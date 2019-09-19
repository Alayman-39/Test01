package com.yc.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.dao.TypeItemInfoDAO;
import com.yc.impl.TypeIteminfoDAOImpl;
import com.yc.po.TypeIteminfoPO;
@WebServlet("/TypeIteminfo.action")
public class TypeIteminfoServlet extends BaseServlet{

	TypeItemInfoDAO dao = new TypeIteminfoDAOImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 2799160801586074144L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op=request.getParameter("op");
		if("findall".equals(op)){
			doFindAll(request,response);
		}
	}

	private void doFindAll(HttpServletRequest request, HttpServletResponse response) {
		TypeIteminfoPO po = parserRequestToObject(request, TypeIteminfoPO.class);
		try {
			List<TypeIteminfoPO> list = dao.find(po);
			toPrintString(response, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
