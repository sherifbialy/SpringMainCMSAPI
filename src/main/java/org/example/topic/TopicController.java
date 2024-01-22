package org.example.topic;




import com.sumerge.bean.Topic;
import com.sumerge.bean.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {


    private final TopicService topicService;
    @Autowired
    public TopicController(TopicService topicService) {
        Assert.notNull(topicService, "topicService must not be null!");
        this.topicService = topicService;
    }
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getTopics();
    }
    @RequestMapping(value = "/topics",method = RequestMethod.POST)
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);

    }
    @RequestMapping(value = "/topics/{id}",method = RequestMethod.PUT)
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(topic,id);

    }
    @RequestMapping(value = "/topics/{id}",method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);

    }
}
