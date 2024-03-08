package sleepjo.run;

import sleepjo.model.dao.MenuDAO;

import java.sql.Connection;
import java.util.Scanner;

import static sleepjo.common.JDBCTemplate.getConnection;

public class Application {
    public static void main(String[] args) {

        Connection con = getConnection();
        MenuDAO registDAO = new MenuDAO();
        Scanner sc = new Scanner(System.in);
        int input;
        do {
            System.out.println("1. 전체 메뉴 조회\n 2. 메뉴 등록\n3. 메뉴 삭제\n4. 메뉴 업데이트\n5. 프로그램 종료");
            System.out.println("========================");
            System.out.print("입력: ");
            input = sc.nextInt();
            if(input > 5 || input < 0) {
                System.out.println("잘못된 입력값 입니다.");
                System.out.println("============================");
            }
        } while(input != 5);

    }
}
