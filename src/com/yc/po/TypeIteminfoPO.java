package com.yc.po;

import java.io.Serializable;

public class TypeIteminfoPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8575458326574425590L;
	private Integer tino;//类型编号
	private String tname;//类型名称
	private Integer tno;// 所属一级分类
	private Integer status;//状态
	public Integer getTino() {
		return tino;
	}
	public void setTino(Integer tino) {
		this.tino = tino;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Integer getTno() {
		return tno;
	}
	public void setTno(Integer tno) {
		this.tno = tno;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
