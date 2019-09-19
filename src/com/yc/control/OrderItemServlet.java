package com.yc.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.dao.OrderItemDAO;
import com.yc.impl.OrderItemDAOImpl;
import com.yc.po.MemberPO;
import com.yc.po.OrderIteminfoPO;
import com.yc.vo.OrderItemVO;
import com.yc.vo.OrderVO;

@WebServlet("/orderItem.action")
public class OrderItemServlet extends BaseServlet {

	OrderItemDAO dao = new OrderItemDAOImpl();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1243052265798328851L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("find".equals(op)) {
			doFind(request, response);
		} else if ("updateOrder".equals(op)) {
			doUpdateOrder(request, response);
		} else if ("add".equals(op)) {
			try {
				doAdd(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ("reducenum".equals(op)) {
			doReduceNum(request, response);
		} else if ("addnum".equals(op)) {
			doAddNum(request, response);
		} else if ("findAll".equals(op)) {
			doFindAll(request, response);
		} else if ("findTable".equals(op)) {
			doFindTable(request, response);
		}

	}

	private void doFindTable(HttpServletRequest request, HttpServletResponse response) {
		OrderVO vo = parserRequestToObject(request, OrderVO.class);
		MemberPO member = (MemberPO) request.getSession().getAttribute("member");
		try {
			if (null == member) {
				toPrintString(response, 2);
				return;
			} else {

				List<OrderVO> list = dao.find(vo);
				toPrintString(response, list);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void doFindAll(HttpServletRequest request, HttpServletResponse response) {
		OrderItemVO vo = new OrderItemVO();
		List<OrderItemVO> list;
		try {
			vo.setStatus(1);
			list = dao.findAll(vo);
			if (list == null || list.size() <= 0) {
				return;
			}
			toPrintString(response, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void doAddNum(HttpServletRequest request, HttpServletResponse response) {
		OrderVO vo = parserRequestToObject(request, OrderVO.class);
		OrderIteminfoPO po = new OrderIteminfoPO();
		po.setOino(vo.getOino());
		po.setOrprice(vo.getPrice());
		try {
			int i = dao.addNum(po);
			toPrintString(response, i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void doReduceNum(HttpServletRequest request, HttpServletResponse response) {
		OrderVO vo = parserRequestToObject(request, OrderVO.class);
		OrderIteminfoPO po = new OrderIteminfoPO();
		po.setOino(vo.getOino());
		po.setOrprice(vo.getOrprice());
		try {
			int i = dao.reduceNum(po);
			toPrintString(response, i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

	private void doAdd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		OrderIteminfoPO po = parserRequestToObject(request, OrderIteminfoPO.class);

		po.setStatus(1);

		List<OrderIteminfoPO> list = dao.findByGno(po);
		int i = 0;
		if (null == list || list.size() <= 0) {
			i = dao.addItem(po);
			toPrintString(response, i);

		} else {
			i += dao.updateNum(po);
			toPrintString(response, i);
		}

	}

	private void doUpdateOrder(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		OrderIteminfoPO po = parserRequestToObject(request, OrderIteminfoPO.class);
		try {
			int i = dao.updateOrderItem(po);

			toPrintString(response, i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doFind(HttpServletRequest request, HttpServletResponse response) {
		OrderVO vo = parserRequestToObject(request, OrderVO.class);
		MemberPO member = (MemberPO) request.getSession().getAttribute("member");

		try {
			if (null == member) {
				toPrintString(response, 2);
				return;
			} else {
				vo.setStatus(1);
				List<OrderVO> list = dao.find(vo);
				toPrintString(response, list);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
