/*
 * author : Vivek Burungale
 */
package com.beverage.repository;

import java.util.List;

import com.beverage.model.OrderDetails;

public interface OrderDao {
	
	String getItemPrice(String itemName);
	String getIngredientsPrice(String exItems);

}
