package com.parklot;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * ClassName ServletInitializer 打包
 * Description TODO
 * Author lezi
 * Date 2021/4/27 20:35
 * Version 1.0
 **/
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RubbishClassificationApplication.class);
    }
}
