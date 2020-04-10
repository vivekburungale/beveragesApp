/*
 * author : Vivek Burungale
 */
package com.beverage.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.beverage.exception.OrderItemNotFoundException;
import com.beverage.model.OrderModel;

public class Helper {

	public List<OrderModel> getOrderItem(String orderDetails) {
		OrderModel model = new OrderModel();
		List<OrderModel> lstmodel = new ArrayList<OrderModel>();
		String menuItems = getMenuItem(orderDetails);
		String exItems = getExclusionItem(orderDetails);
		model.setItemName(menuItems);
		model.setExclusionItem(exItems);
		lstmodel.add(model);
		return lstmodel;
	}

	public String getMenuItem(String orderDetails) {
		List<String> lines = Arrays.asList(orderDetails.split(","));
		if (lines.size() == 0) {
			throw new OrderItemNotFoundException("Order " + orderDetails);
		}
		String itemName = lines.get(0);
		return itemName;
	}

	public String getExclusionItem(String orderDetails) {
		List<String> lines = Arrays.asList(orderDetails.split(","));
		String excItems = "";
		if (orderDetails.contains("-")) // means some are ingredients are excluded
		{
			excItems = lines.stream() // convert list to stream
					.filter(line -> line.contains("-")) // we will check for item exclusion
					.distinct() // removes any duplicates ingredients
					.collect(Collectors.joining("','", "'", "'")); // collect the output and convert to List by adding
		} // single quote for each items
		excItems = excItems.replaceAll("-", "");

		return excItems;

	}

}