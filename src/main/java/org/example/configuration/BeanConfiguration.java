package org.example.configuration;

import org.example.course.CourseRepository;
import org.example.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Autowired
    private CourseRepository courseRepository;
    @Bean(name = "courseService")
    public CourseService courseService(){

        return new CourseService(courseRepository);
    }

    @Bean(name = "otherCourseService")
    public CourseService otherCourseService(){

        return new CourseService(courseRepository);
    }
}
