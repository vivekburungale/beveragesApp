package com.beverage.model;

/*
 * author : Vivek Burungale
 */
import org.springframework.stereotype.Component;

@Component
public class OrderModel {
	String itemName;
	String exclusionItem;

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

}
