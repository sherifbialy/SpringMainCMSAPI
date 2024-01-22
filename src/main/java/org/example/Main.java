package org.example;


import com.sumerge.bean.BeanApplication;
import com.sumerge.bean.BeanConfig;
import com.sumerge.bean.Topic;
import com.sumerge.bean.TopicRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import({BeanApplication.class}) //have somebody explain this
@EntityScan(basePackages = {"com.sumerge.bean","org.example"})
@EnableJpaRepositories(basePackages = {"com.sumerge.bean","org.example"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}