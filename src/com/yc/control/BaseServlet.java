package com.yc.control;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.yc.util.LogUtil;

public class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4412111599162714443L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	/**
	 * easyui分页json各式数据
	 * 
	 * @param response
	 * @param obj
	 * @throws IOException
	 */
	public void toPrintString(HttpServletResponse response, Object obj, int total) throws IOException {
		Gson gson = new Gson();
		String info = gson.toJson(obj);
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"total\":" + total + ",\"rows\":");
		sb.append(info);
		sb.append("}");
		System.out.println(sb.toString());
		response.getWriter().print(sb.toString());
	}

	/**
	 * 将对象转为json字符串
	 * 
	 * @param response
	 * @param obj
	 * @throws IOException
	 */
	public void toPrintString(HttpServletResponse response, Object obj) throws IOException {
		Gson gson = new Gson();
		String info = gson.toJson(obj);
		response.getWriter().print(info);
	}

	/**
	 * 整形
	 * 
	 * @param response
	 * @param i
	 * @throws IOException
	 */
	public void toPrintString(HttpServletResponse response, Integer i) throws IOException {
		Gson gson = new Gson();
		String info = gson.toJson(i);
		response.getWriter().print(info);
	}

	/**
	 * 字符串
	 * 
	 * @param response
	 * @param str
	 * @throws IOException
	 */

	public void toPrintString(HttpServletResponse response, String str) throws IOException {
		Gson gson = new Gson();
		String info = gson.toJson(str);
		response.getWriter().print(info);
	}

	/**
	 * 解析请求对象数据封装到javaBean对象
	 * 
	 * @param request
	 * @param cls
	 * @return
	 */
	public <T> T parserRequestToObject(HttpServletRequest request, Class<T> cls) {
		T t = null;
		try {
			// 获取所有属性
			Field[] fields = cls.getDeclaredFields();
			// 获取所有的方法
			Method[] methods = cls.getDeclaredMethods();
			// 根据cls创建对象
			t = cls.newInstance();
			String value = null;
			String fieldName = null;
			for (Field field : fields) {
				fieldName = field.getName();
				// 根据属性取值 页面的name属性值必须和javabean对象属性名一致
				value = request.getParameter(fieldName);
				// 当页面没有传入值的时候
				if (null == value || "".equals(value)) {
					continue;
				}
				Object obj;
				for (Method m : methods) {
					if (("set" + fieldName).equalsIgnoreCase(m.getName())) {
						String paramType = m.getParameterTypes()[0].getName();
						// 值的数据类型与固定类型字符串比较
						if ("java.lang.Integer".equals(paramType)) {
							m.invoke(t, Integer.parseInt(value));
						} else if ("java.lang.Double".equals(paramType)) {
							m.invoke(t, Double.parseDouble(value));
						} else if ("java.lang.Float".equals(paramType)) {
							m.invoke(t, Float.parseFloat(value));
						} else if ("java.lang.Long".equals(paramType)) {
							m.invoke(t, Long.parseLong(value));
						} else if ("java.lang.String".equals(paramType)) {
							m.invoke(t, value);
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LogUtil.log.debug(e.getMessage());
		}
		return t;
	}

}
