package Converter.MVC.Konstantin.courses;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CourseDollar implements CourseImplement {

    @Override
    public double getCourse(String url) throws IOException {

        Document doc = Jsoup.connect(url).get();
        Elements courses = doc.selectXpath("/html/body/main/div[2]/div/div[1]/div/section[2]/div/table/tbody/tr[1]/td[2]");
        for(Element course : courses){
            course.hasText();
        }
        return 0;
    }
}
