package com.yc.vo;

import java.io.Serializable;

public class OrderItemVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4885531340295023498L;
private Integer oino;
	
	private String ono;
	private String odate;
	private Integer ano;
	private Double  price;
	private Integer status;
	private String sdate;
	private String rdate;
	private Integer pno;
	private  Integer invoice;
	private String cancelDate;
	private String reason;
	private String spare;
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

	public String getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
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

	public Integer getInt() {
		return Int;
	}

	public void setInt(Integer i) {
		Int = i;
	}

	private String reserve;
	


	private Integer gno;
	private Integer num;
	private  Double  orprice;

	private Integer Int;
	

}
