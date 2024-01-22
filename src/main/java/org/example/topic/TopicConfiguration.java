package org.example.topic;


import com.sumerge.bean.TopicRepository;
import com.sumerge.bean.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfiguration {

    @Autowired
    private  TopicRepository topicRepository;

    @Bean
    @ConditionalOnMissingBean(type = "TopicService")
    public TopicService localTopicService(){
        return new TopicService(topicRepository);

    }
}
