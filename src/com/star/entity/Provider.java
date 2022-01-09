package com.star.entity;

//采购退货表
public class Provider {
	private String pbid;//编号
	private Custom custom;//退货客户id
	private Stock stock;//销售id
	private String date;//退货时间
	private double totalprice;//退货总价
	
	public String getPbid() {
		return pbid;
	}
	public void setPbid(String pbid) {
		this.pbid = pbid;
	}
	public Custom getCustom() {
		return custom;
	}
	public void setCustom(Custom custom) {
		this.custom = custom;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
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
