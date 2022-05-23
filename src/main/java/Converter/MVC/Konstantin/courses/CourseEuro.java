package Converter.MVC.Konstantin.courses;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class CourseEuro extends CourseAbstract implements CourseImplement {

    public void courseVision() {
        init(url);
        System.out.println(course);
    }

    public double getCourse(String url) throws IOException {

        Document doc = Jsoup.connect(url).get();

        Elements tables = doc.getElementsByTag("tbody");
        Element table = tables.get(0);

        Elements euro_elements = table.children();
        String[] euro = euro_elements.get(1).text().replace("EUR", "").split(" ");

        double course = Double.parseDouble(euro[1].replace(",", "."));
        return course;
    }

}
