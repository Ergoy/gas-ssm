package com.star.entity;

//������ϸ��
public class SellDetail {
	private String sdid;//���
	private Sell sell;//����sid
	private Goods goods;//��Ʒgid
	private int amount;//����
	private double price;//����
	public String getSdid() {
		return sdid;
	}
	public void setSdid(String sdid) {
		this.sdid = sdid;
	}
	public Sell getSell() {
		return sell;
	}
	public void setSell(Sell sell) {
		this.sell = sell;
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
