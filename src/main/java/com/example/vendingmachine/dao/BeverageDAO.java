package com.example.vendingmachine.dao;

import com.example.vendingmachine.model.Ingredient;

import java.util.Map;

/**
 * DAO interface for Beverage
 *
 * @author rajatgoyal715
 */
public interface BeverageDAO {

    public Map<Ingredient, Integer> getBeverageIngredients(String beverageName) throws Exception;

    public void addBeverage(String beverageName, Map<Ingredient, Integer> ingredients) throws Exception;
}
