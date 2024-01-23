package org.example.course;


import org.example.configuration.BeanConfiguration;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CourseController.class)
@Import(BeanConfiguration.class)
public class CourseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
//    @Qualifier("courseService")
    private CourseService courseService;

//    @MockBean
//    private CourseRepository courseRepository;



    @Test
    public void getAllCoursesInFlutter() throws Exception {
        var course = new Course("Flutter Bootcamp", "Placeholder", "flutter");
        Mockito.when(courseService.getCourses("flutter")).thenReturn(List.of(course));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/topics/flutter/courses")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", is("Flutter Bootcamp")));
    }
}
