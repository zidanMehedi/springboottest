package org.testproject.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topics> mapGetAllTopics(){
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topics mapGetTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void mapAddTopic(@RequestBody Topics topic){
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, /*value = "/topics/{id}",*/ value = "/topics")
    public void mapUpdateTopic(/*@PathVariable String id,*/ @RequestBody Topics topic){
        topicService.updateTopic(/*id,*/ topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void mapDeleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
