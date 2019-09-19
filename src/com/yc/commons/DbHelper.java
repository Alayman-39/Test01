package com.yc.commons;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Blob;



public class DbHelper {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	static {
		try {
			Class.forName(MyProperties.getInstance().getProperty("driver"));
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConn() throws SQLException{
		conn = DriverManager.getConnection(MyProperties.getInstance().getProperty("url"), MyProperties.getInstance());
		return conn;
	}
	
	public void closeAll(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if (null != rs) {
			try {
				rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if (null != stmt) {
			try {
				stmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if (null != conn) {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public <E> List<E> findMutil(String sql, List<Object> params, Class<E> cls) throws Exception {
		// TODO Auto-generated method stub
		List<E> list = new ArrayList<E>();
		conn = getConn();
		pstmt = conn.prepareStatement(sql);
		setparams(pstmt, params);
		rs = pstmt.executeQuery();
		List<String> columnNames = getColumnNames(rs);
		E e;//对象
		Object obj;//获取对应字段的值
		
		//获取所有的方法  通过反射
		Method [] methods=cls.getDeclaredMethods();
		
		while(rs.next()){
			//创建对象
			e=cls.newInstance();//调用无参数的构造函数
			//循环列名
			for(String columnName:columnNames){
				String typeName=null;//值的数据类型
				//获取到值
				obj=rs.getObject(columnName);
				//判断是否为空
				if(null==obj){
					continue;
				}
				typeName=obj.getClass().getName();
				//激活setXXX  完成赋值操作
				for(Method m:methods){
					//找到对应列的名字与之匹配的set方法
					if(("set"+columnName).equalsIgnoreCase(m.getName())){
						//值的数据类型与固定类型字符串比较
						if("java.math.BigDecimal".equals(typeName)){
							m.invoke(e, rs.getInt(columnName));//oracle整形处理
						}else if("java.lang.Integer".equals(typeName)){
							m.invoke(e, rs.getInt(columnName));
						}else if("java.lang.Double".equals(typeName)){
							m.invoke(e, rs.getDouble(columnName));
						}else if("java.lang.Long".equals(typeName)){
							m.invoke(e, rs.getLong(columnName));
						}else if("java.lang.Float".equals(typeName)){
							m.invoke(e, rs.getFloat(columnName));
						}else if("java.lang.String".equals(typeName)){
							m.invoke(e, rs.getString(columnName));
						}else if("java.lang.BLOB".equals(typeName)){
							//将blob转为字节数组
							Blob blob = (Blob)obj;
							InputStream in = blob.getBinaryStream();
							byte[] bt = new byte[(int) blob.length()];
							in.read(bt);
							//将字节数组存到Map中
							m.invoke(e, bt);
						}else{
							m.invoke(e, obj.toString());
						}
						break;
					}
				}
				
			}
			list.add(e);
			
		}
		return list;
	}

	

	public List<Map<String, Object>> selectMulti(String sql, List<Object> params) throws SQLException{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			setparams(pstmt, params);
			rs = pstmt.executeQuery();
			List<String> columnNames = getColumnNames(rs);
			while(rs.next()) {
				map = new HashMap<String, Object>();
				for(String name : columnNames) {
					System.out.println(name);
					map.put(name, rs.getObject(name));
				}
				list.add(map);
			}
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return list;
	}
	
	public Map<String, Object> selectSingle(String sql, List<Object> params) throws SQLException{
		Map<String, Object> map = null;
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			setparams(pstmt, params);
			rs = pstmt.executeQuery();
			List<String> columnNames = getColumnNames(rs);
			if (rs.next()) {
				map = new HashMap<String, Object>();
				for(String name : columnNames) {
					System.out.println(name);map.put(name, rs.getObject(name));
				}
			}
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return map;
	}

	public List<String> getColumnNames(ResultSet rs2) throws SQLException {
		ResultSetMetaData data = rs.getMetaData();
		int count = data.getColumnCount();
		List<String> columnNames = new ArrayList<String>();
		for(int i = 1; i <= count; i++) {
			columnNames.add(data.getColumnName(i));
		}
		return columnNames;
	}

	public void setparams(PreparedStatement pstmt2, List<Object> params) throws SQLException {
		if (null == params || params.size() <= 0) {
			return;
		}
		for(int i = 0; i < params.size(); i++) {
			pstmt.setObject(i+1, params.get(i));
		}
	}

	public int update(String sql, Object...params) throws SQLException{
		int result = 0;
		try {
			conn = getConn();
			pstmt = conn.prepareStatement(sql);
			setParamterObject(pstmt, params);
			result = pstmt.executeUpdate();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return result;
	}

	public void setParamterObject(PreparedStatement pstmt2, Object...params) throws SQLException{
		if (null == params || params.length <= 0) {
			return;
		}
		for(int i = 0; i < params.length; i++) {
			pstmt.setObject(i+1, params[i]);
		}
	}
	
	public int update(List<String> sqls, List<List<Object>> params) throws SQLException {
		int result = 0;
		try {
			conn = getConn();
			conn.setAutoCommit(false);
			if (null == sqls || sqls.size() <= 0) {
				return result;
			}
			for(int i = 0; i < sqls.size(); i++) {
				String sql = sqls.get(i);
				pstmt = conn.prepareStatement(sql);
				List<Object> param = params.get(i);
				setparams(pstmt, param);
				result = pstmt.executeUpdate();
			}
			conn.commit();
		} catch(SQLException e) {
			e.printStackTrace();
			conn.rollback();
			result = 0;
		} finally {
			conn.setAutoCommit(true);
			closeAll(conn, pstmt, null);
		}
		return result;
	}
public double getPromer(String sql,List<Object> params) throws SQLException {
	double result=0;
		try {
		conn=getConn();
		pstmt=conn.prepareStatement(sql);
		setparams(pstmt,params);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			result=rs.getDouble(1);
		}
	}finally {
		closeAll(conn,pstmt,rs);
	}
	
	return result;
}



}

