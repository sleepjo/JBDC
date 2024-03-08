package sleepjo.model.dao;

import sleepjo.model.dto.MenuDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static sleepjo.common.JDBCTemplate.close;

public class MenuDAO {
    private Properties prop = new Properties();

    public MenuDAO(){
        try {
            prop.loadFromXML( new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public int UpdateMenu(Connection con, MenuDTO newMenu) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("UpdateMenu");

        try {
            pstmt = con.prepareStatement(query);

            pstmt.setInt(1,newMenu.getMenuCode());
            pstmt.setString(2,newMenu.getMenuName());
            pstmt.setInt(3,newMenu.getMenuPrice());
            pstmt.setInt(4, newMenu.getCategoryCode());
            pstmt.setString(5, newMenu.getOrderableStatus());

            result = pstmt.executeUpdate();
            System.out.println(pstmt);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            close(pstmt);
        }
        return result;

    }


}
