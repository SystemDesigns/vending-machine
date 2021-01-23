package com.example.vendingmachine.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible to implement {@link StockDAO} and keep the stock in memory
 *
 * @author rajatgoyal715
 */
public class StockDAOImpl implements StockDAO {

    Map<String, Integer> stock;

    public StockDAOImpl() {

        stock = new HashMap<>();
        stock.put("hot_water", 500);
        stock.put("hot_milk", 500);
        stock.put("coffee_decoction", 100);
        stock.put("sugar_syrup", 100);
        stock.put("tea_leaves_syrup", 100);
        stock.put("green_tea_syrup", 100);
    }

    @Override
    public Map<String, Integer> getStock() {
        return stock;
    }

    @Override
    public int getStock(String ingredientName) {

        checkIfIngredientIsPresent(ingredientName);
        return stock.get(ingredientName);
    }

    @Override
    public synchronized void addStock(String ingredientName, int amount) throws Exception {

        checkIfIngredientIsPresent(ingredientName);

        if (amount < 0) {
            throw new Exception("You can not add negative amount of stock for any ingredient");
        }

        int currentStock = stock.get(ingredientName);
        stock.put(ingredientName, currentStock + amount);
    }

    @Override
    public boolean hasAvailableStock(String ingredientName, int amount) {

        checkIfIngredientIsPresent(ingredientName);

        int currentStock = stock.get(ingredientName);
        return currentStock >= amount;
    }

    @Override
    public synchronized void consumeStock(String ingredientName, int amount) throws Exception {

        checkIfIngredientIsPresent(ingredientName);

        int currentStock = stock.get(ingredientName);
        if (currentStock < amount) {
            throw new Exception("Current stock(" + currentStock + ") of ingredient - "
                    + ingredientName + " is less than the requested amount (" + amount + ")");
        }
        stock.put(ingredientName, currentStock - amount);
    }

    private boolean checkIfIngredientIsPresent(String ingredientName) {

        if (!stock.containsKey(ingredientName)) {
            throw new UnsupportedOperationException("Coffee machine don't support this ingredient : " + ingredientName);
        }
        return true;
    }

}
