package com.yc.vo;

import java.io.Serializable;

public class OrderVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5214338962536720530L;

	private Integer oino;//订单详细编号
	private String ono;//所属订单
	private Integer tino;
	private	String gname;
	private Integer balance;
	private String place;
	private Integer gno;// 商品编号
	private String  unit;
	private String pics;
	private Double weight;
	private Integer num;//购买数量
	private String qualityPeriod;
	private String descr;
	private Double price;//购买单价
	private Integer status;//状态
	private  Double  orprice;
	private String spare;//
	private String reserve;//
	private Integer comments;//评价
	
	public Integer getTino() {
		return tino;
	}
	public void setTino(Integer tino) {
		this.tino = tino;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPics() {
		return pics;
	}
	public void setPics(String pics) {
		this.pics = pics;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public String getQualityPeriod() {
		return qualityPeriod;
	}
	public void setQualityPeriod(String qualityPeriod) {
		this.qualityPeriod = qualityPeriod;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Double getOrprice() {
		return orprice;
	}
	public void setOrprice(Double orprice) {
		this.orprice = orprice;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
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
