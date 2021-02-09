package az.orient.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Qr45hibernateApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(Qr45hibernateApplication.class, args);

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Qr45hibernateApplication.class);
    }


}
