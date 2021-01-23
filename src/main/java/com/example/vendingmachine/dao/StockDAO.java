package com.example.vendingmachine.dao;

import java.util.Map;

/**
 * This interface is responsible to define the methods for database layer of Stock
 *
 * @author rajatgoyal715
 */
public interface StockDAO {

    public int getStock(String ingredientName);

    public Map<String, Integer> getStock();

    public void addStock(String ingredientName, int amount) throws Exception;

    public boolean hasAvailableStock(String ingredientName, int amount);

    public void consumeStock(String ingredientName, int amount) throws Exception;
}
