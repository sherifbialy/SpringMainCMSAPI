package org.example.configuration;

import org.example.course.CourseRepository;
import org.example.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration

public class BeanConfiguration {

    @Autowired
    private CourseRepository courseRepository;
    @Bean
    public CourseService courseService(){

        return new CourseService(courseRepository);
    }

//    @Bean(name = "otherCourseService")
//    public CourseService otherCourseService(){
//
//        return new CourseService(courseRepository);
//    }
//    @Bean(name="entityManagerFactory")
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//
//        return sessionFactory;
//    }
}
