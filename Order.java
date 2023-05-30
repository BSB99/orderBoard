package sparta.buggerOrder;

import java.util.ArrayList;

public class Order extends Menu{
    static ArrayList<Order> orderList = new ArrayList<>();

    double price;

    public Order(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
