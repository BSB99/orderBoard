package sparta.buggerOrder;
import java.util.ArrayList;

public class Menu {
    static ArrayList<Shop> menuList = new ArrayList<>();
    static ArrayList<Order> orderList = new ArrayList<>();
    static ArrayList<Amount> amountList = new ArrayList<>();
    static ArrayList<Shop> drinkList = new ArrayList<>();

    static ArrayList<Shop> sideList = new ArrayList<>();
    String name;
    String description;
    public static void setMenu(int orderNum) {

        switch (orderNum) {
            case 1:
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
                break;
            case 2:
                if (drinkList.size() < 4) {
                    Shop menu1 = new Shop("coke", 2.0, "탄산이 톡 쏘는 콜라");
                    Shop menu2 = new Shop("cider", 2.0, "탄산이 톡 쏘는 사이다");
                    Shop menu3 = new Shop("coffee", 1.5, "카페인이 함유된 커피");
                    Shop menu4 = new Shop("water", 1.0, "삼다수");

                    drinkList.add(0, menu1);
                    drinkList.add(1, menu2);
                    drinkList.add(2, menu3);
                    drinkList.add(3, menu4);
                }
                break;
            case 3:
                if (sideList.size() < 4) {
                    Shop menu1 = new Shop("nugget", 1.8, "치킨너겟");
                    Shop menu2 = new Shop("French fries", 2.0, "감자튀김");
                    Shop menu3 = new Shop("cheese stick", 1.5, "치즈스틱");
                    Shop menu4 = new Shop("squid ring", 2.5, "오징어링");

                    sideList.add(0, menu1);
                    sideList.add(1, menu2);
                    sideList.add(2, menu3);
                    sideList.add(3, menu4);
                }
                break;
        }

        getMenus(orderNum);
    }

    public static void getMenus(int orderNum) {

        switch (orderNum) {
            case 1:
                System.out.println("[ Burgers MENU ]");

                for (int i = 0; i < menuList.size(); i++) {
                    Shop burger = menuList.get(i);
                    System.out.printf("%-2d. %-15s | 가격: $%3.1f | 설명: %s%n", (i + 1), burger.getName(), burger.getPrice(), burger.getDescription());
                }
                break;
            case 2:
                System.out.println("[ Drinks MENU ]");

                for (int i = 0; i < drinkList.size(); i++) {
                    Shop drink = drinkList.get(i);
                    System.out.printf("%-2d. %-15s | 가격: $%3.1f | 설명: %s%n", (i+1), drink.getName(), drink.getPrice(), drink.getDescription());
                }
                break;
            case 3:
                System.out.println("[ Sides MENU ]");

                for (int i = 0; i < sideList.size(); i++) {
                    Shop side = sideList.get(i);
                    System.out.printf("%-2d. %-15s | 가격: $%3.1f | 설명: %s%n", (i+1), side.getName(), side.getPrice(), side.getDescription());
                }
                break;
        }
    }

    public static Shop setMenu (int orderNum, int choiceNum) {
        Shop menu;

        if (orderNum == 1) {
            menu = menuList.get(choiceNum - 1);
            return menu;
        } else if (orderNum == 2) {
            menu = drinkList.get(choiceNum - 1);
            return menu;
        } else {
            menu = sideList.get(choiceNum - 1);
            return menu;
//            return new String[]{"err"};  // orderNum이 1이나 2가 아닌 경우에 대한 처리
        }
    }

    public static String[] menuChoice(int choiceNum, int orderNum) {
        Shop menu = setMenu(orderNum, choiceNum);

        String name = menu.getName();
        double price = menu.getPrice();
        String description = menu.getDescription();
        System.out.println(name + " " + price + "$ " + description);

        String[] result = new String[]{name, String.valueOf(price), description};

        if (orderNum == 1) {
            System.out.println("\n위 메뉴의 어떤 옵션으로 추가하시겠습니까?\n" +
                    "1. Single(W " + menu.getPrice() + ")        2. LargeSet(W "+ (menu.getPrice() + 1.5)+")");
        } else if (orderNum == 2) {
            System.out.println("\n위 메뉴의 어떤 옵션으로 추가하시겠습니까?\n" +
                    "1. Single(W "+menu.getPrice()+")        2. Large(W "+(menu.getPrice()+1.5)+")");
        }

        return result;
    }

    public static String[] setOption(int orderNum, int optionNum, String[] choiceMenu) {
        String name = choiceMenu[0];
        double price = Double.parseDouble(choiceMenu[1]);
        String description = choiceMenu[2];
        String comment = name + "(S) " + price + "$ " + description;
        String largeComment = name + "(L) "+ (price + 1) + "$ " + description;
        String orderComment = "위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                "1. 확인        2. 취소";

        if (orderNum == 1 || orderNum == 2) {
            if (optionNum == 1) {
                System.out.println(comment);
                return new String[]{name += "(S)", String.valueOf(price), description};
            } else {
                System.out.println(largeComment);
                return new String[] {name, String.valueOf(price+1), description};
            }
        } else {
            System.out.println(orderComment);
            return new String[] {name, String.valueOf(price), description};
        }
    }
    public static void setOrder(String[] value) {
        String name = value[0];
        double price = Double.parseDouble(value[1]);
        String description = value[2];
        int cnt = 1;

        boolean hasSameName = false;

        if (orderList.size() >= 1) {
            for (Order order : orderList) {
                if (order.getName().equals(name)) {
                    hasSameName = true;
                    order.setCnt();
                    break;
                }
            }
        }

        if (!hasSameName) {
            Order menu1 = new Order(name, description, price, cnt);
            orderList.add(0, menu1);
        }
        System.out.println(name + "가 장바구니에 추가되었습니다.");
    }

    public static void getOrder() {
        Double price = 0.0;

        for (Order menu : orderList) {
            price += menu.getPrice() * menu.getCnt();
            System.out.print(String.format("%-15s",menu.getName()));
            System.out.print("| 가격: $ " + menu.getPrice());
            System.out.print(" | " + menu.getCnt()+"개 | ");
            System.out.println(menu.getDescription());
            System.out.println();
        }

        System.out.println("[ Total ]\n" +
                "W "+String.format("%2.1f",price));

        System.out.println("1. 주문      2. 메뉴판");
    }

    public static void setClearOrder() {
        orderList.clear();
    }

    public static void setAmount() { // 총액 합계
        for (Order menu : orderList) {
            String orderName = menu.getName();
            double orderPrice = menu.getPrice();
            int cnt = menu.getCnt();
            Amount menu1 = new Amount(orderName, orderPrice, cnt);
            amountList.add(0, menu1);
        }
    }

    public static void getAmount() {
        double total = 0.0;

        System.out.println("[ 합계 ]");
        for (int i = 0; i < amountList.size(); i++) {
            Amount list = amountList.get(i);
            total += list.getPrice() * list.getCnt();
            System.out.print(i+1 + ". 메뉴명: " + String.format("%-15s",list.getName()));
            System.out.print("| 가격: $ " + list.getPrice());
            System.out.println(" | 개수: " + list.getCnt() + "개");
        }

        System.out.println("총합 = " + String.format("$%2.1f", total));
        System.out.println("1. 돌아가기");
    }
}
