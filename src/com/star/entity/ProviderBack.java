package com.star.entity;

//采购退货明细表
public class ProviderBack {
	private String pbdid;//编号
	private Provider provider;//退货id
	private Goods goods;//商品id
	private int amount;//数量
	private double price;//单价
	
	public String getPbdid() {
		return pbdid;
	}
	public void setPbdid(String pbdid) {
		this.pbdid = pbdid;
	}
	public Provider getProvider() {
		return provider;
	}
	public void setProvider(Provider provider) {
		this.provider = provider;
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
