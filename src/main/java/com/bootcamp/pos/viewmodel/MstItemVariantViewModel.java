package com.bootcamp.pos.viewmodel;

public class MstItemVariantViewModel {
	private int id;
	private int itemId;
	private String name;
	private String sku;
	private Double price;
	private int beginningStock;
	private int alertAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getBeginningStock() {
		return beginningStock;
	}
	public void setBeginningStock(int beginningStock) {
		this.beginningStock = beginningStock;
	}
	public int getAlertAt() {
		return alertAt;
	}
	public void setAlertAt(int alertAt) {
		this.alertAt = alertAt;
	}
}
