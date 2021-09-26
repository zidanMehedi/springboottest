package org.testproject.springbootstarter.course;

import org.testproject.springbootstarter.topic.Topics;

import javax.persistence.*;

@Entity
public class Courses {

    @Id
    private String id;
    private String name;

    @ManyToOne
    private Topics topic;

    public Courses() {
    }

    public Topics getTopic() {
        return topic;
    }

    public void setTopic(Topics topic) {
        this.topic = topic;
    }

    public Courses(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
