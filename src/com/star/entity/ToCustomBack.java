package com.star.entity;

//�ͻ��˻���ϸ��
public class ToCustomBack {
	private String cbdid;//���
	private ToCustom cust;//�˻�id
	private Goods goods;//��Ʒid
	private int amount;//����
	private double price;//����
	
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
