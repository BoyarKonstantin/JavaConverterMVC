package Converter.MVC.Konstantin.courses;

import java.io.IOException;

public abstract class CourseAbstract implements CourseImplement {
    protected double course;
    private Thread secondThread;
    private Runnable runnable;

    /*Метод создания нового потока для запуска парсинга курса*/
    public void courseVision() {
    }

    protected void init(String url) {
        runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    getCourse(url);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        };
        secondThread = new Thread();
        secondThread.start();
    }

    /*Метод который должен вытягивать данные курса и возвращать их*/
    public double getCourse(String url) throws IOException {
        return course;
    }

    public void setCourse(double course) {
        this.course = course;
    }
}
