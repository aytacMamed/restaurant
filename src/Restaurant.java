import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Order> orders;
    private Menu menu;

    public Restaurant() {
        orders = new ArrayList<>();
        menu = new Menu();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
