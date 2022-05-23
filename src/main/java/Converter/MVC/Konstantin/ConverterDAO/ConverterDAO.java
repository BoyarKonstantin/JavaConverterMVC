package Converter.MVC.Konstantin.ConverterDAO;

import Converter.MVC.Konstantin.models.ValuteModel;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    /*Создаем публичный метод индекс в который пихаем логику итерации
    по всем по объектам БД а также добавление говна в твою БД, которую обмазываем
    исключением потому что так надо*/
    public List<ValuteModel> index() {
        List<ValuteModel> valuteModelList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * From converter";
            statement.executeQuery(SQL);
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                ValuteModel valuteModel = new ValuteModel();

                valuteModel.setValuteName(resultSet.getString("valutename"));
                valuteModel.setCourse(resultSet.getDouble("valutecourse"));
                valuteModel.setCurrentDate(resultSet.getDate("datecourse"));
                valuteModelList.add(valuteModel);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return valuteModelList;
    }

}
