package org.testproject.springbootstarter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("topics/{topicId}/courses")
    public List<Courses> mapGetAllCourses(@PathVariable String topicId){
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("topics/courses/{id}")
    public Courses mapGetCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }

    @RequestMapping("topics/{topicId}/courses/{id}")
    public Courses mapGetCourse(@PathVariable String topicId, @PathVariable String id){
        return courseService.getCourseByTopic(topicId, id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "topics/{topicId}/courses")
    public void mapAddCourse(@PathVariable String topicId, @RequestBody Courses course){
        courseService.addCourse(topicId, course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "topics/{topicId}/courses")
    public void mapUpdateCourse(@PathVariable String topicId, @RequestBody Courses course){
        courseService.updateCourse(topicId, course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "topics/{topicId}/courses/{id}")
    public void mapDeleteCourse(@PathVariable String topicId, @PathVariable String id){
        courseService.deleteCourse(id);
    }
}
