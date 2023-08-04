package com.entity;

public class Order {
	
	private int order_id;
	private int cid;
	private int item_id;
	private int qty;
	private float tCost;
	public Order() {
		super();
	}
	public Order(int order_id, int cid, int item_id, int qty, float tCost) {
		super();
		this.order_id = order_id;
		this.cid = cid;
		this.item_id = item_id;
		this.qty = qty;
		this.tCost = tCost;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float gettCost() {
		return tCost;
	}
	public void settCost(float tCost) {
		this.tCost = tCost;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", cid=" + cid + ", item_id=" + item_id + ", qty=" + qty + ", tCost="
				+ tCost + "]";
	}
	
	

}
