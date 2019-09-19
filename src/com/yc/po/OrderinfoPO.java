package com.yc.po;

import java.io.Serializable;

public class OrderinfoPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1726039692401264275L;

	private String ono;//订单编号
	private String odate;//订购日期
	private Integer ano;//收货地址信息
	private Double price;//订单总价
	private Integer status;//订单状态
	private String sdate;//发货日期
	private String rdate;//收货日期
	private Integer pno;//支付方式
	private Integer invoice;//是否已经开发票
	private String cancleDate;//取消日期
	private String reason;//取消原因
	private String spare;//备用字段
	private String reserve;//备用字段
	public String getOno() {
		return ono;
	}
	public void setOno(String ono) {
		this.ono = ono;
	}
	public String getOdate() {
		return odate;
	}
	public void setOdate(String odate) {
		this.odate = odate;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
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
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public Integer getPno() {
		return pno;
	}
	public void setPno(Integer pno) {
		this.pno = pno;
	}
	public Integer getInvoice() {
		return invoice;
	}
	public void setInvoice(Integer invoice) {
		this.invoice = invoice;
	}
	public String getCancleDate() {
		return cancleDate;
	}
	public void setCancleDate(String cancleDate) {
		this.cancleDate = cancleDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
