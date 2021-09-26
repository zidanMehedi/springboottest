package org.testproject.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

//    private List<Topics> topicList = new ArrayList(Arrays.asList(
//            new Topics("1", "Java"),
//            new Topics("2", "Php"),
//            new Topics("3", "JS")
//    ));

    public List<Topics> getAllTopics(){
        //return topicList;
        List<Topics> topics = new ArrayList<Topics>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topics getTopic(String id){
//        return topicList.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
        return topicRepository.findOne(id);
    }

    public void addTopic(Topics topic) {
//        topicList.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(/*String id,*/ Topics topic) {
//        byte i = 0;
//        while(i < topicList.size()){
//            Topics tpc = topicList.get(i);
//            if(tpc.getId().equals(id)){
//                topicList.set(i, topic);
//            }
//            i++;
//        }
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
//        topicList.removeIf(topic->topic.getId().equals(id));
        topicRepository.delete(id);
    }
}
