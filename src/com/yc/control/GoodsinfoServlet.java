package com.yc.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.dao.GoodsinfoDAO;
import com.yc.impl.GoodsDAOImpl;
import com.yc.po.GoodsPO;
@WebServlet("/goodsinfo.action")
public class GoodsinfoServlet extends BaseServlet{

	GoodsinfoDAO dao = new GoodsDAOImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = -333405643736145407L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("find".equals(op)) {
			doFind(request, response);
		} else if ("findtype".equals(op)) {
			doFindType(request, response);
		}else if ("findAll".equals(op)) {
			doFindAll(request, response);
		}
	}

	
	private void doFindAll(HttpServletRequest request, HttpServletResponse response) {
		GoodsPO po = parserRequestToObject(request, GoodsPO.class);
		try {
			List<GoodsPO> list = dao.find(po);
			toPrintString(response, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void doFindType(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void doFind(HttpServletRequest request, HttpServletResponse response) {
		GoodsPO po = parserRequestToObject(request, GoodsPO.class);
		try {
			List<GoodsPO> list = dao.find(po);
			Map<Integer, List<GoodsPO>> map = new HashMap<>();
			for (GoodsPO goodsPO : list) {
				List<GoodsPO> glist = map.get(goodsPO.getTino());
				if(glist == null){
					glist = new ArrayList<>();
				}
				glist.add(goodsPO);
				map.put(goodsPO.getTino(), glist);
				//System.out.println(glist);
			}
			toPrintString(response, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
