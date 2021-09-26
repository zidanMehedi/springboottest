package org.testproject.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testproject.springbootstarter.topic.Topics;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Courses> getAllCourses(String topicId){
        List<Courses> courses = new ArrayList<Courses>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Courses getCourse(String id){
        return courseRepository.findOne(id);
    }

    public Courses getCourseByTopic(String topicId, String id){
        List<Courses> courses = new ArrayList<Courses>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses.stream().filter(course->course.getId().equals(id)).findFirst().get();
    }

    public void addCourse(String topicId, Courses course) {
        course.setTopic(new Topics(topicId, ""));
        courseRepository.save(course);
    }

    public void updateCourse(String topicId, Courses course) {
        course.setTopic(new Topics(topicId, ""));
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.delete(id);
    }
}
