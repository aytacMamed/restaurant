import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Meal meal1 = new Meal("Burger", 9.99);
        Meal meal2 = new Meal("Pizza", 12.99);
        Drink drink1 = new Drink("Coke", 1.99);
        Drink drink2 = new Drink("Water", 0.99);

       
        Menu menu = new Menu();
        menu.addMeal(meal1);
        menu.addMeal(meal2);
        menu.addDrink(drink1);
        menu.addDrink(drink2);


        Restaurant restaurant = new Restaurant();
        restaurant.setMenu(menu);


        Scanner scanner = new Scanner(System.in);


        System.out.println("Welcome to the restaurant! Place your order.");

        boolean orderingFinished = false;

        while (!orderingFinished) {
            Order order = new Order();

            try {
                System.out.println("Do you want to order a meal? (Y/N)");
                String mealChoice = scanner.next();

                if (mealChoice.equalsIgnoreCase("Y")) {
                    System.out.println("Enter the meal number (1-" + menu.getMeals().size() + "):");
                    int mealNumber = scanner.nextInt();
                    order.addMeal(menu.getMeals().get(mealNumber - 1));
                }

                System.out.println("Do you want to order a drink? (Y/N)");
                String drinkChoice = scanner.next();

                if (drinkChoice.equalsIgnoreCase("Y")) {
                    System.out.println("Enter the drink number (1-" + menu.getDrinks().size() + "):");
                    int drinkNumber = scanner.nextInt();
                    order.addDrink(menu.getDrinks().get(drinkNumber - 1));
                }

                if (!mealChoice.equalsIgnoreCase("Y") && !drinkChoice.equalsIgnoreCase("Y")) {
                    System.out.println("Invalid input. At least one item (meal or drink) must be ordered.");
                    continue;
                }

                restaurant.addOrder(order);
            } catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                scanner.nextLine();
                continue;
            }

            System.out.println("Do you want to place another order? (Y/N)");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("N")) {
                orderingFinished = true;
            }
        }


        scanner.close();

        // Get the orders and display their details
        List<Order> orders = restaurant.getOrders();
        for (Order order : orders) {
            System.out.println("Order:");
            List<Meal> meals = order.getMeals();
            for (Meal meal : meals) {
                System.out.println("Meal: " + meal.getName() + ", Price: " + meal.getPrice());
            }
            List<Drink> drinks = order.getDrinks();
            for (Drink drink : drinks) {
                System.out.println("Drink: " + drink.getName() + ", Price: " + drink.getPrice());
            }
            System.out.println("Total Price: " + order.getTotalPrice());
            System.out.println();
        }

        // Get the menu and display the available meals and drinks
        Menu menuu = restaurant.getMenu();
        System.out.println("Menu:");
        List<Meal> meals = menuu.getMeals();
        for (int i = 0; i < meals.size(); i++) {
            System.out.println("Meal " + (i + 1) + ": " + meals.get(i).getName() + ", Price: " + meals.get(i).getPrice());
        }
        Menu menuuu = restaurant.getMenu();
        System.out.println("Menu:");
        List<Meal> mealss = menuuu.getMeals();
        for (int i = 0; i < mealss.size(); i++) {
            System.out.println("Meal " + (i + 1) + ": " + mealss.get(i).getName() + ", Price: " + mealss.get(i).getPrice());
        }

        List<Drink> drinks = menu.getDrinks();
        for (int i = 0; i < drinks.size(); i++) {
            System.out.println("Drink " + (i + 1) + ": " + drinks.get(i).getName() + ", Price: " + drinks.get(i).getPrice());
        }

}
}