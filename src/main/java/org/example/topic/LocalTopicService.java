package org.example.topic;

import com.sumerge.bean.Topic;
import com.sumerge.bean.TopicRepository;

import java.util.List;

public class LocalTopicService {



    private final TopicRepository repository;

    public LocalTopicService(TopicRepository repository) {
        this.repository = repository;
    }

    public List<Topic> getTopics() {
        return this.repository.findAll();
    }

    public Topic getTopic(String id) {
        return this.repository.findById(id).get();

    }

    public void addTopic(Topic topic) {
        this.repository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
//        this.topics.stream().filter((elem)->elem.getId().equals(id)).findFirst().ifPresent((elem)->{
//            elem.setDescription(topic.getDescription());
//            elem.setName(topic.getName());
//            elem.setId(topic.getId());
//        });
        this.repository.save(topic);
    }

    public void deleteTopic(String id) {
//      this.topics.removeIf((elem)->elem.getId().equals(id));
        this.repository.deleteById(id);
    }
}
