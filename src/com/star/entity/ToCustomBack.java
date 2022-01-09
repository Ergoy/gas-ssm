package com.star.entity;

//客户退货明细表
public class ToCustomBack {
	private String cbdid;//编号
	private ToCustom cust;//退货id
	private Goods goods;//商品id
	private int amount;//数量
	private double price;//单价
	
	public String getCbdid() {
		return cbdid;
	}
	public void setCbdid(String cbdid) {
		this.cbdid = cbdid;
	}
	public ToCustom getCust() {
		return cust;
	}
	public void setCust(ToCustom cust) {
		this.cust = cust;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
