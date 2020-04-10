/*
 * author : Vivek Burungale
 */

package com.beverage.model;

import org.springframework.stereotype.Component;

@Component
public class OrderDetails {
	String itemName;
	String exclusionItem;
	String orderPrice;
	String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getExclusionItem() {
		return exclusionItem;
	}

	public void setExclusionItem(String exclusionItem) {
		this.exclusionItem = exclusionItem;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

}
