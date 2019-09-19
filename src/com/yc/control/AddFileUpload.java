package com.yc.control;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import com.yc.dao.GoodsinfoDAO;
import com.yc.impl.GoodsDAOImpl;
import com.yc.po.GoodsPO;

@WebServlet("/AddFileUpload.action")
public class AddFileUpload extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GoodsinfoDAO dao = new GoodsDAOImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 文件上传
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		String gname = null;// 商品名称
		String tino = null;// 所属类型
		String price = null;// 商品单价
		String intro = null;// 商品简介
		String balance = null;// 商品库存
		String unit = null;// 商品单位
		String place = null;// 商品产地
		String qualityPeriod = null;// 保质期
		String weight = null;// 净重
		String pics = null;// 商品图片
		String descr = null;// 商品描述
		// 解析请求对象
		try {
			List<FileItem> list = upload.parseRequest(request);
			if (null == list) {
				return;
			}

			for (FileItem item : list) {
				if (item.isFormField()) {
					// 普通的表单元素
					if ("gname".equals(item.getFieldName())) {
						gname = item.getString("UTF-8");
					} else if ("tino".equals(item.getFieldName())) {
						tino = item.getString("UTF-8");
					} else if ("price".equals(item.getFieldName())) {
						price = item.getString("UTF-8");
					} else if ("intro".equals(item.getFieldName())) {
						intro = item.getString("UTF-8");
					} else if ("balance".equals(item.getFieldName())) {
						balance = item.getString("UTF-8");
					} else if ("unit".equals(item.getFieldName())) {
						unit = item.getString("UTF-8");
					} else if ("place".equals(item.getFieldName())) {
						place = item.getString("UTF-8");
					} else if ("qualityPeriod".equals(item.getFieldName())) {
						qualityPeriod = item.getString("UTF-8");
					} else if ("weight".equals(item.getFieldName())) {
						weight = item.getString("UTF-8");
					} else if ("descr".equals(item.getFieldName())) {
						descr = item.getString("UTF-8");
					}
				} else {
					// 路径
					String path = request.getServletContext().getRealPath("/");
					// 解决文件重名的问题
					String fileName = new Random().nextInt(1000) + System.currentTimeMillis() + "" + item.getName();
					File file = new File(path, "../fresh_goods/" + fileName);
					item.write(file);
					pics = "../fresh_goods/" + file.getName();
				}
			}
			GoodsPO po = new GoodsPO();
			po.setGname(gname);
			po.setTino(Integer.parseInt(tino));
			po.setPrice(Double.parseDouble(price));
			po.setIntro(intro);
			po.setBalance(Integer.parseInt(balance));
			po.setUnit(unit);
			po.setPlace(place);
			po.setQualityPeriod(qualityPeriod);
			po.setWeight(Double.parseDouble(weight));
			po.setPics(pics);
			po.setDescr(descr);
			int i = dao.addGoods(po);
			System.out.println("i的值：" + i);
			if (i > 0) {
				toPrintString(response, 1);
			} else {
				toPrintString(response, 0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
