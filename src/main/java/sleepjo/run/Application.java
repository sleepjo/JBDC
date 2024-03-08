package sleepjo.run;

import sleepjo.model.dao.MenuDAO;
import sleepjo.model.dto.MenuDTO;

import java.sql.Connection;
import java.util.Scanner;

import static sleepjo.common.JDBCTemplate.getConnection;

public class Application {
    public static void main(String[] args) {

        Connection con = getConnection();
        MenuDAO registDAO = new MenuDAO();

        Scanner sc = new Scanner(System.in);
        System.out.print("등록 메뉴의 코드를 입력해주세요. : ");
        int menuCode = sc.nextInt();
        System.out.print("수정하실 메뉴의 이름을 입력해주세요 : ");
        String menuName = sc.nextLine();
        System.out.println("판매 메뉴에 등록이 완료되었습니다. ");

        System.out.println("또 수정하실 메뉴가 있으신가요? (예/아니오) : ");
        String answer = sc.nextLine();
        while (answer == "예") {

        }


//        int result = 0;

        MenuDTO newMenu = new MenuDTO(menuCode, menuName);

        int result = registDAO.UpdateMenu(con, newMenu);

        if (result > 0) {
            System.out.println("메뉴 수정 성공!!");
        } else {
            System.out.println("메뉴 수정 실패...ㅠ");
        }
    }
}
