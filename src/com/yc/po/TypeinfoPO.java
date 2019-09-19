package com.yc.po;

import java.io.Serializable;

public class TypeinfoPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 775315819700791584L;
	private Integer tno;//类型编号
	private String tname;//类型名称
	private Integer status;//状态
	public Integer getTno() {
		return tno;
	}
	public void setTno(Integer tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
