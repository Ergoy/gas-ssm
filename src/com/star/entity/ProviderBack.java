package com.star.entity;

//�ɹ��˻���ϸ��
public class ProviderBack {
	private String pbdid;//���
	private Provider provider;//�˻�id
	private Goods goods;//��Ʒid
	private int amount;//����
	private double price;//����
	
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
