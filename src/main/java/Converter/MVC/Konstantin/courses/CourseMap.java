package Converter.MVC.Konstantin.courses;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CourseMap implements CourseImplement{
    public static Map<String, Double> courseMap() {
        CourseEuro courseEuro = new CourseEuro();
        CourseDollar courseDollar = new CourseDollar();
        Map<String, Double> course = new HashMap<>();
        try {
            course.put("USD", courseDollar.getCourse(url));
            course.put("EUR", courseEuro.getCourse(url));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return course;
    }

    @Override
    public double getCourse(String url) throws IOException {
        return 0;
    }
}
