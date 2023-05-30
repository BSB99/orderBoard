package sparta.buggerOrder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String dashBoard = "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n" +
                "\n" +
                "[ SHAKESHACK MENU ]\n" +
                "1. Burgers         | 앵거스 비프 통살을 다져만든 버거\n" +
                "2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림\n" +
                "3. Drinks          | 매장에서 직접 만드는 음료\n" +
                "4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주\n" +
                "\n" +
                "[ ORDER MENU ]\n" +
                "5. Order       | 장바구니를 확인 후 주문합니다.\n" +
                "6. Cancel      | 진행중인 주문을 취소합니다.";
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        Scanner sc = new Scanner(System.in);
        String orderNum = sc.nextLine();
        String checkNum = "";

        while (orderNum.equals("0")) {
            System.out.println(dashBoard); // 메뉴판 보여주기
            orderNum = sc.nextLine();
            if (orderNum.equals("1")) {
                Menu.setBurger();          // 버거 저장 후 목록 보여주기
                orderNum = sc.nextLine();
                String[] burger = Menu.burgerChoice(orderNum);
                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                        "1. 확인        2. 취소");
                checkNum = sc.nextLine();
                if (checkNum.equals("1")) {   // 장바구니에 담기
                    Menu.setOrder(burger);
                    orderNum = "0";
                    continue;
                } else {                    // 장바구니에 안담으면 다시 메뉴판이 보임
                    orderNum = "0";
                    continue;
                }
            } else if (orderNum.equals("5")) { // 장바구니 목록
                Menu.getOrder();
            }
        }
    }
}
