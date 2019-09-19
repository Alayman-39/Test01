//package com.yc.util;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import com.yc.dao.IGroupBuyDAO;
//import com.yc.impl.GroupBuyDAOImpl;
//import com.yc.po.GroupBuyPO;
//
//public class StringUtil {
//
//	/**
//	 * 判断是否为空
//	 * @param str
//	 * @return
//	 */
//	public static boolean isEmpty(String str) {
//		if(null==str || "".equals(str)){
//			return true;
//		}
//		return false;
//	}
//
//	/**
//	 * 根据团购编号生成订单编号
//	 * @param gbid
//	 * @return
//	 */
//	public static String genOrderId(int gbid){
//		Date date = new Date();
//		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//		return "a"+format.format(date)+gbid;
//	}
//	
//	/**
//	 * 获取套餐中所有的商品类型
//	 * @return
//	 * @throws Exception
//	 */
//	public static String getAllGid() throws Exception{
//		IGroupBuyDAO dao = new GroupBuyDAOImpl();
//		GroupBuyPO po = null;
//		List<GroupBuyPO> list = dao.findByPage(po, null, null);
//		StringBuffer sb = new StringBuffer();
//		for(GroupBuyPO p:list){
//			sb.append(p.getG_id());
//		}
//		return sb.toString().substring(0, sb.length()-1);
//	}
//	
//	public static void main(String[] args) throws Exception {
//		System.out.println(getAllGid());
//	}
//}
