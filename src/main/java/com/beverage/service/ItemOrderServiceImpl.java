/**
 * 
 */
package com.beverage.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beverage.exception.OrderItemNotFoundException;
import com.beverage.model.OrderDetails;
import com.beverage.repository.OrderDao;

@Service
public class ItemOrderServiceImpl implements ItemOrderService {

	@Autowired
	private OrderDao orderDao;

	@Override
	public String placeOrder(String itemName, String excItems) {
		// TODO Auto-generated method stub
		float totalOrderCost = 0;

		String itemCost = orderDao.getItemPrice(itemName);
		if (!itemCost.equals("-1")) {
			String ingredientsCost = orderDao.getIngredientsPrice(excItems);
			totalOrderCost = Float.parseFloat(itemCost) - Float.parseFloat(ingredientsCost);
		} else {
			return "-1";
		}

		return String.valueOf(totalOrderCost);
	}

	@Override
	public String placeOrder(String itemName) {

		String itemCost = orderDao.getItemPrice(itemName);

		return itemCost;
	}

}
