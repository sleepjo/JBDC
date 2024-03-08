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
            System.out.println("1. 전체 메뉴 조회\n2. 메뉴 등록\n3. 메뉴 삭제\n4. 메뉴 업데이트\n5. 프로그램 종료");
            System.out.println("========================");
            System.out.print("입력: ");
            input = sc.nextInt();
            if(input > 5 || input < 0) {
                System.out.println("잘못된 입력값 입니다.");
                System.out.println("============================");
            }

            switch (input){
                case 1 : // 전체메뉴조회
                    break;
                case 2: // 메뉴 등록
                    break;
                case 3: // 메뉴 삭제
                    break;
                case 4: // 메뉴 업데이트
            }






        } while(input != 5);
        System.out.println("프로그램이 종료 됩니다.");

    }
}
