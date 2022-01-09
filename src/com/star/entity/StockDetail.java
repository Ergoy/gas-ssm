package com.star.entity;

//采购明细表
public class StockDetail {
	private String sdid;//编号
	private Stock stock;//采购sid
	private Goods goods;//商品gid
	private int amount;//数量
	private double price;//单价
	
	public String getSdid() {
		return sdid;
	}
	public void setSdid(String sdid) {
		this.sdid = sdid;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
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
