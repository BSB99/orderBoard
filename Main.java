package sparta.buggerOrder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String dashBoard = "아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n" +
                "\n" +
                "[ SHAKESHACK MENU ]\n" +
                "1. Burgers         | 앵거스 비프 통살을 다져만든 버거\n" +
                "2. Drinks          | 버거와 같이 마실 음료수\n" +
                "3. Sides           | 버거와 같이 먹을 간식\n" +
                "\n" +
                "[ ORDER MENU ]\n" +
                "4. Order       | 장바구니를 확인 후 주문합니다.\n" +
                "5. Cancel      | 진행중인 주문을 취소합니다.";
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        Scanner sc = new Scanner(System.in);
        int orderNum = 1;
        int count = 1;
        while (true) {
            System.out.println(dashBoard);
            System.out.print("\n번호를 입력해 주세요 ==> ");
            orderNum = sc.nextInt();
            switch (orderNum) {
                case 0:
                    Menu.getAmount();
                    int managerNum = sc.nextInt();
                    if (managerNum == 1) {
                        continue;
                    } else {
                        continue;
                    }
                case 1, 2, 3:
                    Menu.setMenu(orderNum);
                    break;
                case 4:
                    System.out.println("아래와 같이 주문 하시겠습니까?");
                    Menu.getOrder();
                    int choiceNum = sc.nextInt();
                    if (choiceNum == 1) {
                        try {
                        Menu.setAmount();
                        Menu.setClearOrder();
                        System.out.println("주문이 완료되었습니다!\n" +
                                "\n" +
                                "대기번호는 [ " + String.format("%d",count) +" ] 번 입니다.\n"+
                                "(3초후 메뉴판으로 돌아갑니다.)");
                        Thread.sleep(3000);
                        count ++;
                        continue;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            continue;
                        }
                    } else {
                        continue;
                    }
                case 5:
                    System.out.println("진행하던 주문을 취소하시겠습니까?\n" +
                        "1. 확인        2. 취소");
                    choiceNum = sc.nextInt();
                    if (choiceNum == 1) {
                        Menu.setClearOrder();
                        continue;
                    } else {
                        continue;
                    }
                default:
                    System.out.println("없는 번호 입니다!");
                    continue;
                }
            System.out.print("\n메뉴 번호를 입력해 주세요 ==>");

            int choiceNum = sc.nextInt();
            String[] menu = Menu.menuChoice(choiceNum, orderNum);

            int optionNum = sc.nextInt();
            String[] options = Menu.setOption(orderNum, optionNum, menu);

            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                        "1. 확인        2. 취소");

            int checkNum = sc.nextInt();

            if (checkNum == 1) {   // 장바구니에 담기
                   Menu.setOrder(options);
                   continue;         // 장바구니에 담고 메뉴판으로 돌아가기 위해 0으로 설정
               } else {                    // 장바구니에 안담으면 다시 메뉴판이 보임
                   continue;
               }
        }
    }
}
