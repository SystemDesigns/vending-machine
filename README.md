# Vending Machine

## Problem Statement
You have to code a working coffee machine which can stock ingredients, prepare beverages, display the current quantity of stock available. One or
more ingredients will be used to prepare beverages. Same ingredients can be used to prepare multiple beverages. Initial ingredients’ stock and the
ingredients required to prepare each beverage will be given. Coffee machine displays success messages for stocking ingredients and preparing
beverages. It also displays proper error messages with all the missing ingredients in case of unavailability of stock.

The coffee machine can stock with the following ingredients:

| Ingredients       | Initial Qty of Stock  |
| ----------------- | --------------------  |
| hot_water         | 500                   |
| hot_milk          | 500                   |
| coffee_decoction  | 100                   |
| sugar_syrup       | 100                   |
| tea_leaves_syrup  | 100                   |
| green_leaves_syrup| 100                   |

The coffee machine can prepare the following beverages:

| Beverages     | Ingredients required to prepare beverages                                 |
| ------------- | ------------------------------------------------------------------------- |
| hot_tea       | hot_water - 200, hot_milk - 100, sugar_syrup - 30, tea_leaves_syrup - 30  |
| hot_coffee    | hot_water - 100, hot_milk - 400, coffee_decoction - 50, sugar_syrup - 30  |
| black_tea     | hot_water - 300, sugar_syrup - 30, tea_leaves_syrup - 30  |
| green_tea     | hot_water - 200, sugar_syrup - 20, green_leaves_syrup - 30  |

### Sample test case
You can use console to take the inputs or implement them as test cases
```
add_stock(“hot_water”,100)
add_stock(“sugar_syrup”, 200)
get_stock()
prepare(“black_tea”)
prepare(“hot_coffee”)
get_stock()
prepare(“green_tea”)
get_stock()
```

### Expectations
1. Make sure that you have a working and demonstrable code.
2. Make sure that the code is functionally complete.
3. Exceptions and edge cases should be handled and appropriate error messages should be displayed wherever required.
4. Clean API design along with modularity and readability of the code.
5. Proper usage of object oriented concepts is expected.
6. Extensibility - the code should easily accommodate new requirements with minimal changes.

### Bonus Problem Statement
- Write functional test cases for the library
- Functionality to enable/disable beverages from coffee machine temporarily