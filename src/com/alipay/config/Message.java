package com.alipay.config;

import java.io.Serializable;

public class Message implements Serializable{

	private String code;
	private String msg;
	private String out_trade_no;
	private String send_pay_date;
	private String trade_status;
	@Override
	public String toString() {
		return "Message [code=" + code + ", msg=" + msg + ", out_trade_no=" + out_trade_no + ", send_pay_date="
				+ send_pay_date + ", trade_status=" + trade_status + "]";
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getSend_pay_date() {
		return send_pay_date;
	}
	public void setSend_pay_date(String send_pay_date) {
		this.send_pay_date = send_pay_date;
	}
	public String getTrade_status() {
		return trade_status;
	}
	public void setTrade_status(String trade_status) {
		this.trade_status = trade_status;
	}
	
	
}
