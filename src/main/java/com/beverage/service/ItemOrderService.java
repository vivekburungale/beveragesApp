/**
 * 
 */
package com.beverage.service;

import com.beverage.model.OrderDetails;

public interface ItemOrderService {

	

	String placeOrder(String itemName, String excItems);

	String placeOrder(String itemName);

}
