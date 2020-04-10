package com.beverage.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
	@PersistenceContext
	private EntityManager entityManager;

	public String getItemPrice(String itemName) {
		String itemPrice = "-1";
		try {

			String sql = "select item_price from menu_items where item_name=?";
			Query q = entityManager.createNativeQuery(sql);
			q.setParameter(1, itemName);
			itemPrice = q.getSingleResult().toString();
		} catch (NoResultException err) {

		}
		return itemPrice;
	}

	public String getIngredientsPrice(String exItems) {
		String ingredientsCost = "0";
		try {
			String sql = "select SUM(price) from ingredients where lower(ingname) IN (" + exItems + ")";
			Query q = entityManager.createNativeQuery(sql);
			ingredientsCost = q.getSingleResult().toString();
		} catch (NoResultException err) {

		}
		return ingredientsCost;
	}

}
