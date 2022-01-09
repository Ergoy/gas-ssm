package com.star.entity;

//客户退货表
public class ToCustom {
	private String cbid;//编号
	private Custom custom;//退货客户id
	private Sell sell;//销售id
	private String date;//退货时间
	private double totalprice;//退货总价
	
	public String getCbid() {
		return cbid;
	}
	public void setCbid(String cbid) {
		this.cbid = cbid;
	}
	public Custom getCustom() {
		return custom;
	}
	public void setCustom(Custom custom) {
		this.custom = custom;
	}
	public Sell getSell() {
		return sell;
	}
	public void setSell(Sell sell) {
		this.sell = sell;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	
}
