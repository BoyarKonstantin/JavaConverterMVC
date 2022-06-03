package Converter.MVC.Konstantin.ConverterDAO;

import Converter.MVC.Konstantin.courses.CourseImplement;
import Converter.MVC.Konstantin.courses.CourseMap;
import Converter.MVC.Konstantin.models.ValuteModel;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class ConverterDAO {
    private static String valuteName;
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";

    private static final String USERNAME = "posgres";

    private static final String PASSWORD = "Dod900ls";

    Date date = new Date();
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


    public static List<ValuteModel> index() {
        List<ValuteModel> valuteModelList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * From converter";
            statement.executeQuery(SQL);
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                ValuteModel valuteModel = new ValuteModel();

                valuteModel.setId(resultSet.getInt("id"));
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


    public static ValuteModel show(int id) {

        ValuteModel valuteModel = null;
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM converter WHERE id = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            valuteModel = new ValuteModel();

            valuteModel.setId(resultSet.getInt("id"));
            valuteModel.setCurrentDate(resultSet.getDate("datecourse"));
            valuteModel.setValuteName(resultSet.getString("valutename"));
            valuteModel.setCourse(resultSet.getDouble("valutecourse"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return valuteModel;
    }

    public void addCourse(int id, ValuteModel valuteModel) {
        CourseMap courseMap = new CourseMap();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("INSERT INTO converter VALUES(1, ?, ?, ?)");
            preparedStatement.setDate(1, java.sql.Date.valueOf(date.toString()));
            preparedStatement.setString(2, valuteModel.getValuteName());
            preparedStatement
                    .setDouble(3, valuteModel
                            .setCourse(courseMap
                                    .getCourse(CourseImplement.url)));

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
