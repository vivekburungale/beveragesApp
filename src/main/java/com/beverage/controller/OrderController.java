/*
 * author : Vivek Burungale
 */
package com.beverage.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.beverage.helper.Helper;
import com.beverage.model.OrderDetails;
import com.beverage.model.OrderModel;
import com.beverage.service.ItemOrderService;

@Controller
public class OrderController {

	@Autowired
	private ItemOrderService orderService;

	@GetMapping(value = "/order")
	public ResponseEntity<ArrayList<OrderDetails>> orderDetails(@RequestParam String orderDetails) {

		ArrayList<OrderDetails> model = new ArrayList<OrderDetails>();
		List<OrderModel> lstObj = new ArrayList<OrderModel>();
		lstObj = new Helper().getOrderItem(orderDetails);

		for (OrderModel obj : lstObj) {
			String orderPrice;
			OrderDetails orderObj = new OrderDetails();
			String itemName = obj.getItemName();

			String excItems = obj.getExclusionItem();
			if (excItems.trim().equals("")) { // if nothing is excluded then Place Order and Item
				orderPrice = orderService.placeOrder(itemName);
			} else { // If excluded then Subtract the excluded ingredients cost
				orderPrice = orderService.placeOrder(itemName, excItems);
			}
			if (orderPrice.equals("-1"))
				orderObj.setStatus("Item Not Found");
			else
				orderObj.setStatus("SUCCESS");

			orderObj.setExclusionItem(excItems);
			orderObj.setItemName(itemName);
			orderObj.setOrderPrice(orderPrice);

			model.add(orderObj);
		}

		return new ResponseEntity(model, HttpStatus.OK);
	}

}
