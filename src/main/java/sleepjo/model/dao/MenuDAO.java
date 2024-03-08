package sleepjo.model.dao;

import sleepjo.model.dto.MenuDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static sleepjo.common.JDBCTemplate.close;

public class MenuDAO {
    private Properties prop = new Properties();

    public MenuDAO() {
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/sleepjo/mapper/menu-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteMenu(Connection con, MenuDTO menu) {
        PreparedStatement pstmt = null;
        int result = 0;

        String query = prop.getProperty("deleteMenu");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, menu.getMenuCode());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

    public int UpdateMenu(Connection con, int menuCode, String menuName) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("insertMenu");
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(2, menuCode);
            pstmt.setString(1, menuName);

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

    public int insertMenu(Connection con, MenuDTO newMenu) {
        PreparedStatement pstmt = null;
        int result = 0;
        String query = prop.getProperty("insertMenu");
        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, newMenu.getMenuCode());
            pstmt.setString(2, newMenu.getMenuName());
            pstmt.setInt(3, newMenu.getMenuPrice());
            pstmt.setInt(4, newMenu.getCategoryCode());
            pstmt.setString(5, newMenu.getOrderableStatus());
            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
        return result;
    }

    public List<MenuDTO> selectMenuList(Connection con) {
        Statement stmt = null;
        ResultSet rset = null;
        MenuDTO row = null;
        List<MenuDTO> menuList = null;


        String query = prop.getProperty("selectMenuList");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
            menuList = new ArrayList<>();
            while (rset.next()) {
                row = new MenuDTO();
                row.setMenuCode(rset.getInt("MENU_CODE"));
                row.setMenuName(rset.getString("MENU_NAME"));
                row.setMenuPrice(rset.getInt("MENU_PRICE"));
                row.setCategoryCode(rset.getInt("CATEGORY_CODE"));
                row.setOrderableStatus(rset.getString("ORDERABLE_STATUS"));

                menuList.add(row);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(stmt);
            close(rset);
        }

        return menuList;

    }

}
