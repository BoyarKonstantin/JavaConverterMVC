package Converter.MVC.Konstantin.courses;

import java.io.IOException;

public interface CourseImplement {
    final String url = "https://minfin.com.ua/currency/";
    public double getCourse(String url) throws IOException;

    default void init(String url){
        double course;
        Thread secondThread;
        Runnable runnable;
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
}
