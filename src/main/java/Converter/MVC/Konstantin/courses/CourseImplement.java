package Converter.MVC.Konstantin.courses;

import java.io.IOException;

public interface CourseImplement {
    final String url = "https://minfin.com.ua/currency/";
    public double getCourse(String url) throws IOException;
}
