package com.yc.po;

import java.io.Serializable;

public class OrderIteminfoPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4124334708339540448L;
	private Integer oino;//订单详细编号
	private String ono;//所属订单
	private Integer gno;//商品编号
	private Integer num;//购买数量
	private Double orprice;//购买单价
	private Double price;//购买单价
	private Integer status;//状态
	private String spare;//备用字段
	private String reserve;//备用字段
	private Integer comments;//评价状态
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getOino() {
		return oino;
	}
	public void setOino(Integer oino) {
		this.oino = oino;
	}
	public String getOno() {
		return ono;
	}
	public void setOno(String ono) {
		this.ono = ono;
	}
	public Integer getGno() {
		return gno;
	}
	public void setGno(Integer gno) {
		this.gno = gno;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	public Double getOrprice() {
		return orprice;
	}
	public void setOrprice(Double orprice) {
		this.orprice = orprice;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getSpare() {
		return spare;
	}
	public void setSpare(String spare) {
		this.spare = spare;
	}
	public String getReserve() {
		return reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	public Integer getComments() {
		return comments;
	}
	public void setComments(Integer comments) {
		this.comments = comments;
	}

}
