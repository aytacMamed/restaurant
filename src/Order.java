import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Meal> meals;
    private List<Drink> drinks;

    public Order() {
        meals = new ArrayList<>();
        drinks = new ArrayList<>();
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Meal meal : meals) {
            totalPrice += meal.getPrice();
        }
        for (Drink drink : drinks) {
            totalPrice += drink.getPrice();
        }
        return totalPrice;
    }

}
