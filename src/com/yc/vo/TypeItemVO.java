package com.yc.vo;

import java.io.Serializable;

public class TypeItemVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2048320696764707789L;

	private Integer tino;
	private String tname;
	private Integer status;
	private Integer tno;
	public Integer getTino() {
		return tino;
	}
	public void setTino(Integer tino) {
		this.tino = tino;
	}
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
