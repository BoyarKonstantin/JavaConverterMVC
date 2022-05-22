package Converter.MVC.Konstantin.models;

public class ValuteModel {
    private double course;
    private String valuteName;

    private String urlCourse;

    public double getCourse() {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }

    public String getValuteName() {
        return valuteName;
    }

    public void setValuteName(String valuteName) {
        this.valuteName = valuteName;
    }

    public String getUrlCourse() {
        return urlCourse;
    }

    public void setUrlCourse(String urlCourse) {
        this.urlCourse = urlCourse;
    }
}
