package Converter.MVC.Konstantin.ConverterDAO;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class ConverterDAO {
    private static String valuteName;

    private static final String URL = "jdbc:postgresql://localhost:5432/Converter";

    private static final String USERNAME = "postgres";

    private static final String PASSWORD = "Dod900ls";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
