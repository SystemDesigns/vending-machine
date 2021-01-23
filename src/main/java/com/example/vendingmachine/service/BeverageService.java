package com.example.vendingmachine.service;

import com.example.vendingmachine.dao.BeverageDAO;
import com.example.vendingmachine.dao.BeverageDAOImpl;
import com.example.vendingmachine.model.Ingredient;

import java.util.Map;

/**
 * TODO: Class Doc
 *
 * @author rajatgoyal715
 */
public class BeverageService {

    BeverageDAO beverageDAO;

    public BeverageService() {
        beverageDAO = new BeverageDAOImpl();
    }

    public void addBeverage(String beverageName, Map<Ingredient, Integer> ingredients) {
        try {
            beverageDAO.addBeverage(beverageName, ingredients);
        } catch (Exception e) {
            System.out.println("Exception occurred while adding beverage - " + e.getMessage());
        }
    }

    public Map<Ingredient, Integer> getBeverage(String beverageName) {

        Map<Ingredient, Integer> ingredients = null;
        try {
            ingredients = beverageDAO.getBeverageIngredients(beverageName);
            System.out.println("Following ingredients are required to make " + beverageName);
            for(Ingredient ingredient : ingredients.keySet()) {
                System.out.println(ingredient.toString().toLowerCase() + " - " + ingredients.get(ingredient));
            }
        } catch(Exception e) {
            System.out.println("Error occurred while getting beverage - " + beverageName);
            System.out.println(e.getMessage());
        }
        return ingredients;
    }
}
