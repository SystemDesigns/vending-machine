package com.example.vendingmachine.service;

import com.example.vendingmachine.model.Ingredient;

import java.util.HashMap;
import java.util.Map;

/**
 * This class implements {@link BeverageVendingService} to prepare beverages
 *
 * @author rajatgoyal715
 */
public class BeverageVendingServiceImpl implements BeverageVendingService {

    BeverageService beverageService;
    StockService stockService;

    public BeverageVendingServiceImpl(StockService stockService, BeverageService beverageService) {

        this.stockService = stockService;
        this.beverageService = beverageService;
    }

    @Override
    public void prepare(String beverageName) {

        try {

            Map<Ingredient, Integer> ingredientMap = beverageService.getBeverage(beverageName);
            Map<String, Integer> ingredientStringMap = new HashMap<>();
            for(Ingredient ingredient : ingredientMap.keySet()) {
                ingredientStringMap.put(ingredient.toString().toLowerCase(), ingredientMap.get(ingredient));
            }

            Map<String, Integer> shortageStockMap = stockService.byWhatAmountStockIsShortOf(ingredientStringMap);

            if (shortageStockMap.size() == 0) {
                stockService.consumeStock(ingredientStringMap);
                System.out.println("Your beverage has been prepared - " + beverageName);
            } else {
                for(String ingredient : shortageStockMap.keySet()) {
                    System.out.println("Ingredient - " + ingredient + " is short by " + shortageStockMap.get(ingredient) + " units");
                }
            }

        } catch (Exception e) {
            System.out.println("Error occurred while preparing beverage - " + beverageName);
        }
    }
}
