package sleepjo.run;

import sleepjo.model.dao.MenuDAO;
import sleepjo.model.dto.MenuDTO;

import java.sql.Connection;
import java.util.List;
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
                    selectMenu();
                    break;
                case 2: // 메뉴 등록
                    insertMenu(sc);
                    break;
                case 3: // 메뉴 삭제
                    deleteMenu(sc);

                    break;
                case 4: // 메뉴 업데이트

                    break;
            }
            System.out.println("=======================");






        } while(input != 5);
        System.out.println("프로그램이 종료 됩니다.");

        /* 지은. 전체 메뉴 조회 */

        List<MenuDTO> menuList = registDAO.selectMenuList(con);

        for(MenuDTO menu : menuList){
            System.out.println("menu = " + menu);
        }

    }
    public static void insertMenu(Scanner sc){
        System.out.print("추가하고싶은 메뉴 코드: ");
        int menuCode = sc.nextInt();
        System.out.print("추가하고싶은 메뉴 이름: ");
        String menuName = sc.next();
        System.out.print("추가하고싶은 메뉴 가격: ");
        int menuPrice = sc.nextInt();
        System.out.print("추가하고싶은 메뉴의 카테고리 코드: ");
        int categoryCode = sc.nextInt();
        System.out.print("추가하고싶은 메뉴의 주문가능한 상태: ");
        String os = sc.next();

        MenuDTO newMenu = new MenuDTO(menuCode,menuName,menuPrice,categoryCode,os);
        int result = registDAO.insertMenu(con, newMenu);
        if(result > 0) {
            System.out.println("해당 메뉴가 추가되었습니다.");
        } else {
            System.out.println("메뉴 추가에 실패하였습니다.\n메뉴 코드를 다시 확인해주세요.");
        }

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
    public static void selectMenu() {

        /* 지은. 전체 메뉴 조회 */

        List<MenuDTO> menuList = registDAO.selectMenuList(con);

        for (MenuDTO menu : menuList) {
            System.out.println("menu = " + menu);
        }
    }
}
