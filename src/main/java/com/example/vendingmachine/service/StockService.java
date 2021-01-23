package com.example.vendingmachine.service;

import com.example.vendingmachine.dao.StockDAO;
import com.example.vendingmachine.dao.StockDAOImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * This is responsible for managing the complete stock
 *
 * @author rajatgoyal715
 */
public class StockService {

    StockDAO stockDAO;

    public StockService() {
        stockDAO = new StockDAOImpl();
    }

    /**
     * This method is responsible to add given amount of given ingredient to the stock
     * @param ingredientName
     * @param amount
     */
    public void addStock(String ingredientName, int amount) {

        try {
            stockDAO.addStock(ingredientName, amount);

            // we can use Logger instead of println statement
            System.out.println(amount + " amount of Ingredient - " + ingredientName + " has been added to the stock");
        } catch (Exception e) {
            System.out.println("Exception occurred while adding the stock: " + e.getMessage());
        }
    }

    public int getStock(String ingredientName) {

        return stockDAO.getStock(ingredientName);
    }

    public Map<String, Integer> getStock() {

        Map<String, Integer> stock = stockDAO.getStock();
        for(String ingredient : stock.keySet()) {
            System.out.println(ingredient + " - " + stock.get(ingredient));
        }
        return stock;
    }

    public boolean hasAvailableStock(String ingredientName, int amount) {
        return stockDAO.hasAvailableStock(ingredientName, amount);
    }

    public boolean hasAvailableStock(Map<String, Integer> ingredientMap) {

        for(String ingredientName: ingredientMap.keySet()) {
            boolean ingredientAvailable = stockDAO.hasAvailableStock(ingredientName, ingredientMap.get(ingredientName));
            if(!ingredientAvailable) return false;
        }
        return true;
    }

    public Map<String, Integer> byWhatAmountStockIsShortOf(Map<String, Integer> ingredientMap) {

        Map<String, Integer> shortageMap = new HashMap<>();

        for(String ingredientName: ingredientMap.keySet()) {

            int currentStock = stockDAO.getStock(ingredientName);
            int requestedAmount = ingredientMap.get(ingredientName);
            if(currentStock < requestedAmount) {
                shortageMap.put(ingredientName, requestedAmount - currentStock);
            }
        }
        return shortageMap;
    }

    public void consumeStock(String ingredientName, int amount) throws Exception {
        stockDAO.consumeStock(ingredientName, amount);
    }

    public void consumeStock(Map<String, Integer> ingredientMap) throws Exception {

        for(String ingredientName: ingredientMap.keySet()) {
            stockDAO.consumeStock(ingredientName, ingredientMap.get(ingredientName));
        }
    }

}
