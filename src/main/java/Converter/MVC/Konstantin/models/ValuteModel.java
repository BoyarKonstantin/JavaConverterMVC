package Converter.MVC.Konstantin.models;

import Converter.MVC.Konstantin.courses.CourseMap;

import java.util.Date;

public class ValuteModel {

    private static int id;
    private double course;
    private String valuteName;

    private Date currentDate;

    public double getCourse(String valuteName) {

        CourseMap courseMap = new CourseMap();
        return CourseMap.courseMap(valuteName);
    }

    public double setCourse(double course) {
        this.course = course;
        return course;
    }

    public String getValuteName() {
        return valuteName;
    }

    public void setValuteName(String valuteName) {
        this.valuteName = valuteName;
    }


    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
