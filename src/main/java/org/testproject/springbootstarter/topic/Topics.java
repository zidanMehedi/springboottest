package org.testproject.springbootstarter.topic;

import org.testproject.springbootstarter.course.Courses;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "topics")
public class Topics {

    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
//    @JoinColumn(name = "topic_id", referencedColumnName = "id")
    private List<Courses> course;

    public Topics() {
    }

    public Topics(String id, String name) {
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
