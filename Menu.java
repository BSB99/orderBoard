package sparta.buggerOrder;
import java.util.ArrayList;

public class Menu {
    static ArrayList<Shop> menuList = new ArrayList<>();
    static ArrayList<Order> orderList = new ArrayList<>();
    String name;
    String description;
    public static void setBurger() {

        if (menuList.size() < 4) {
            Shop menu1 = new Shop("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            Shop menu2 = new Shop("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
            Shop menu3 = new Shop("Shroom Burger", 9.4, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거");
            Shop menu4 = new Shop("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");

            menuList.add(0, menu1);
            menuList.add(1, menu2);
            menuList.add(2, menu3);
            menuList.add(3, menu4);
        }

        getBurgers();
    }

    public static void getBurgers() {
        for (Shop bugger : menuList) {
            System.out.println("메뉴명: " + bugger.getName());
            System.out.println("가격: $" + bugger.getPrice());
            System.out.println("설명: " + bugger.getDescription());
            System.out.println();
        }
    }

    public static String[] burgerChoice(String num) {
        int number = Integer.parseInt(num) - 1;
        Shop choiceBurger = menuList.get(number);
        String name = choiceBurger.getName();
        double price = choiceBurger.getPrice();
        String description = choiceBurger.getDescription();

        System.out.println(name +" "+ price + "$ " + description);

        String[] result = {name, String.valueOf(price), description};

        return result;
    }
    public static void setOrder(String[] value) {
        String name = value[0];
        double price = Double.parseDouble(value[1]);
        String description = value[2];

        Order menu1 = new Order(name, description, price);
        orderList.add(0, menu1);

        System.out.println(name + "가 장바구니에 추가 되었습니다.");
    }

    public static void getOrder() {
        Double price = 0.0;

        for (Order burger : orderList) {
            System.out.println("메뉴명: " + burger.getName());
            System.out.println("가격: $" + burger.getPrice());
            price += burger.getPrice();
            System.out.println("설명: " + burger.getDescription());
            System.out.println();
        }

        System.out.println("[ Total ]\n" +
                "W "+price);

        System.out.println("1. 주문      2. 메뉴판");
    }

    public static void clearOrder() {
        orderList.clear();
    }
}
