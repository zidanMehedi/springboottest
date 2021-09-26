package org.testproject.springbootstarter.course;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Courses, String> {
    public List<Courses> findByTopicId(String topicId);
}
