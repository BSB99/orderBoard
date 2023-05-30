package sparta.buggerOrder;
import java.util.ArrayList;
public class Menu {
    static String name;
    static String description;

    public static void bugger() {
        ArrayList<shop> menuList = new ArrayList<>();

        shop menu1 = new shop("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        shop menu2 = new shop("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        shop menu3 = new shop("Shroom Burger", 9.4, "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거");
        shop menu4 = new shop("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");

        menuList.add(0, menu1);
        menuList.add(1, menu2);
        menuList.add(2, menu3);
        menuList.add(3, menu4);

        System.out.println(menuList.toString());
        for (shop bugger : menuList) {
            System.out.println("메뉴명: " + bugger.getName());
            System.out.println("가격: $" + bugger.getPrice());
            System.out.println("설명: " + bugger.getDescription());
            System.out.println();
        }
    }
}
