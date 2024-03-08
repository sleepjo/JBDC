package sleepjo.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MenuDAO {
    private Properties prop = new Properties();

    public MenuDAO(){
        try {
            prop.loadFromXML( new FileInputStream("src/main/java/com/ohgiraffers/mapper/menu-query.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
