package com.yc.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yc.util.LogUtil;
import com.yc.dao.MemberinfoDAO;
import com.yc.impl.MemberDAOImpl;
import com.yc.po.MemberPO;
@WebServlet("/member.action")
public class MemberServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1751437968267482963L;

	MemberinfoDAO dao = new MemberDAOImpl();
	protected void  doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String op=request.getParameter("op");
		if("login".equals(op)) {
			doLogin(request,response);
		}else if("register".equals(op)){
			doRegister(request,response);
		}else if("find".equals(op)){
			doFind(request ,response);
		}else if("showinfo".equals(op)){
			doShowInfo(request,response);
		}
	}

	private void doShowInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		MemberPO member =(MemberPO) request.getSession().getAttribute("member");
		if(member ==null){
			toPrintString(response,2);
		}else {
			List<MemberPO> list = new ArrayList<MemberPO>();
			list.add(member);
			toPrintString(response, list);
		}
		
	}

	private void doFind(HttpServletRequest request, HttpServletResponse response) {
		MemberPO po=parserRequestToObject(request, MemberPO.class);
		try {
			List<MemberPO> list = dao.find(po);
			toPrintString(response, list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void doRegister(HttpServletRequest request, HttpServletResponse response) {
		MemberPO po = parserRequestToObject(request, MemberPO.class);
		try {
			int result = dao.register(po);
			if(result>0){
				response.sendRedirect("index.html");
			}else{
				response.sendRedirect("register.html");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogUtil.log.debug("用户注册失败......"+e.getMessage());
		}
		
	}

	private void doLogin(HttpServletRequest request, HttpServletResponse response) {
		MemberPO po = parserRequestToObject(request, MemberPO.class);
		try {
			MemberPO member = dao.login(po);
			if(null==member){
				response.sendRedirect("login.html");
				LogUtil.log.info(member+"登录失败！！！");
			}else{
				LogUtil.log.info(member+"登录成功！！！");
				request.getSession().setAttribute("member", member);
				response.sendRedirect("index.html");	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
