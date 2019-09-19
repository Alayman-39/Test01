package com.yc.control;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.dao.OrderDAO;
import com.yc.dao.OrderItemDAO;
import com.yc.impl.OrderDAOImpl;
import com.yc.impl.OrderItemDAOImpl;
import com.yc.po.OrderIteminfoPO;
import com.yc.po.OrderinfoPO;

@WebServlet("/order.action")
public class OrderServlet extends BaseServlet {

	OrderDAO dao = new OrderDAOImpl();
	OrderItemDAO itemdao = new OrderItemDAOImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 8445733414364699647L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("findAll".equals(op)) {
			doFindAll(request, response);
		} else if ("addorder".equals(op)) {
			doAddorder(request, response);
		}
	}

	private void doAddorder(HttpServletRequest request, HttpServletResponse response) {
		Random rand = new Random();
		OrderinfoPO po = parserRequestToObject(request, OrderinfoPO.class);
		String ono = System.currentTimeMillis() + "" + rand.nextInt(1000);
		po.setOno(ono);
		try {
			dao.addOrder(po);

			OrderIteminfoPO item = new OrderIteminfoPO();
			item.setStatus(1);
			List<OrderIteminfoPO> list = itemdao.findByGno(item);
			int i = 0;
			for (OrderIteminfoPO oitem : list) {
				oitem.setOno(ono);
				i += itemdao.updateOrderItem(oitem);
				
			}
			toPrintString(response, i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void doFindAll(HttpServletRequest request, HttpServletResponse response) {
		OrderinfoPO po = parserRequestToObject(request, OrderinfoPO.class);
		try {
			List<OrderinfoPO> list = dao.findAll(po);
			if (null == list || list.size() <= 0) {
				return;
			}
			toPrintString(response, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
