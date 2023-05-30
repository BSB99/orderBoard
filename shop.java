package sparta.buggerOrder;

import java.util.ArrayList;

public class shop extends Menu{
    static double price;
    public shop (String name, double price, String description) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public static String getName() {
        return name;
    }

    public static double getPrice() {
        return price;
    }

    public static String getDescription() {
        return description;
    }
}
