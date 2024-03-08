package sleepjo.run;

import sleepjo.model.dao.MenuDAO;
import sleepjo.model.dto.MenuDTO;

import java.sql.Connection;
import java.util.Scanner;

import static sleepjo.common.JDBCTemplate.getConnection;

public class Application {

    static MenuDAO registDAO;
    static Connection con;
    public static void main(String[] args) {

        con = getConnection();
        registDAO = new MenuDAO();
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
                    deleteMenu(sc);

                    break;
                case 4: // 메뉴 업데이트
                    UpdateMenu(sc);

                    break;
            }






        } while(input != 5);
        System.out.println("프로그램이 종료 됩니다.");

    }

    public static void deleteMenu(Scanner sc){
        System.out.print("삭제하고 싶은 메뉴 코드를 입력 하세요: ");
        int menuCode = sc.nextInt();
        MenuDTO deletingMenu = new MenuDTO(menuCode,"",0,0,"N");
        int result = registDAO.deleteMenu(con, deletingMenu);

        if(result > 0) {
            System.out.println("해당 메뉴가 삭제되었습니다.");
        } else {
            System.out.println("메뉴 삭제에 실패하였습니다.\n메뉴코드를 다시 확인해주세요.");
        }
    }

    public static void UpdateMenu (Scanner sc){


        while (true) {
            System.out.print("등록 메뉴의 코드를 입력해주세요. : ");
            int menuCode = sc.nextInt();
            System.out.print("수정하실 메뉴의 이름을 입력해주세요 : ");
            sc.nextLine();
            String menuName = sc.nextLine();
            System.out.println("판매 메뉴에 등록이 완료되었습니다. ");

            System.out.println("또 수정하실 메뉴가 있으신가요? (예/아니오) : ");
            String answer = sc.nextLine();
            if (answer.equals("아니오")) {
                break;}
        }

    }
}
