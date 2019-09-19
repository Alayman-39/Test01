package com.yc.vo;

import java.io.Serializable;

public class GoodsVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9153558045803529797L;

	private Integer gno;//商品编号
	private String gname;//商品名称
	private Integer tino;//所属类型
	private Double price;//商品单价
	private String intro;//商品库存
	private String unit;//商品单位
	private String place;//商品产地
	private String qualityPeriod;//保质期
	private Double weight;//净重
	private String pics;//商品图片
	private String descr;//商品描述
	private Integer tno;//类型编号
	private String tname;//类型名称
	private Integer status;//状态
	public Integer getGno() {
		return gno;
	}
	public void setGno(Integer gno) {
		this.gno = gno;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public Integer getTino() {
		return tino;
	}
	public void setTino(Integer tino) {
		this.tino = tino;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getQualityPeriod() {
		return qualityPeriod;
	}
	public void setQualityPeriod(String qualityPeriod) {
		this.qualityPeriod = qualityPeriod;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public String getPics() {
		return pics;
	}
	public void setPics(String pics) {
		this.pics = pics;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
