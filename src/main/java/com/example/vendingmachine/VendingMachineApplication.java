package com.example.vendingmachine;

import com.example.vendingmachine.model.Ingredient;
import com.example.vendingmachine.service.BeverageService;
import com.example.vendingmachine.service.BeverageVendingService;
import com.example.vendingmachine.service.BeverageVendingServiceImpl;
import com.example.vendingmachine.service.StockService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class VendingMachineApplication {

	private static final StockService stockService = new StockService();
	private static final BeverageService beverageService = new BeverageService();

	private static final BeverageVendingService beverageVendingService = new BeverageVendingServiceImpl(stockService, beverageService);

	public static void main(String[] args) {
		SpringApplication.run(VendingMachineApplication.class, args);

		stockService.getStock();
		stockService.addStock("hot_water", 100);
		stockService.addStock("sugar_syrup", 100);
		stockService.getStock();

		beverageVendingService.prepare("black_tea");
		stockService.getStock();

		beverageVendingService.prepare("hot_coffee");
		stockService.getStock();

		// added this functionality to add more beverages
		beverageService.addBeverage("green_tea", Map.of(Ingredient.HOT_WATER, 200, Ingredient.SUGAR_SYRUP, 20, Ingredient.GREEN_TEA_SYRUP, 30));
		beverageService.getBeverage("green_tea");
		beverageVendingService.prepare("green_tea");
		stockService.getStock();
	}

}
