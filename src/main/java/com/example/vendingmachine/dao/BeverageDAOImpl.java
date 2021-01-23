package com.example.vendingmachine.dao;

import com.example.vendingmachine.model.Ingredient;

import java.util.HashMap;
import java.util.Map;

/**
 * In-Memory DAO Implementation of {@link BeverageDAO}
 *
 * @author rajatgoyal715
 */
public class BeverageDAOImpl implements BeverageDAO {

    Map<String, Map<Ingredient, Integer>> beverageMap;

    public BeverageDAOImpl(){
        beverageMap = new HashMap<>();
        beverageMap.put("black_tea", Map.of(Ingredient.HOT_WATER, 300, Ingredient.SUGAR_SYRUP, 20, Ingredient.TEA_LEAVES_SYRUP, 30));
        beverageMap.put("hot_tea", Map.of(Ingredient.HOT_WATER, 200, Ingredient.HOT_MILK, 100, Ingredient.SUGAR_SYRUP, 30, Ingredient.TEA_LEAVES_SYRUP, 30));
        beverageMap.put("hot_coffee", Map.of(Ingredient.HOT_WATER, 300, Ingredient.SUGAR_SYRUP, 20, Ingredient.TEA_LEAVES_SYRUP, 30));
    }

    @Override
    public Map<Ingredient, Integer> getBeverageIngredients(String beverageName) throws Exception {

        throwErrorIfBeverageDoesNotExist(beverageName);

        return beverageMap.get(beverageName);
    }

    @Override
    public void addBeverage(String beverageName, Map<Ingredient, Integer> ingredients) throws Exception {

        if(beverageMap.containsKey(beverageName)) {
            throw new Exception("Beverage - " + beverageName + " is already present there");
        }
        beverageMap.put(beverageName, ingredients);
    }

    private void throwErrorIfBeverageDoesNotExist(String beverageName) throws Exception {

        if (!beverageMap.containsKey(beverageName)) {
            throw new Exception("Beverage - " + beverageName + " is not supported yet.");
        }
    }
}
