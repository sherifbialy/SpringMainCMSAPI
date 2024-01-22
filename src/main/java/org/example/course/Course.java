package org.example.course;


import com.sumerge.bean.Topic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity

public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )

    private Long id;
    private String name;
    private String description;
    @ManyToOne
    private Topic topic;

    public Course(String name, String description, String topicId){
        this.name=name;
        this.description=description;
        this.topic=new Topic(topicId,"","");
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
