package ru.pavel2107.arch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Hw01Application {

    public static void main(String[] args) {
        SpringApplication.run(Hw01Application.class, args);
    }

}
