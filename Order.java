package sparta.buggerOrder;

import java.util.ArrayList;

public class Order extends Menu{
    double price;

    int cnt;

    public Order(String name, String description, double price, int cnt) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.cnt = cnt;
    }

    public Order (String name, double price) {
        this.name = name;
        this.price = price;
    }

    public int setCnt () {
        return cnt += 1;
    }

    public int getCnt () {
        return cnt;
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
