package vis.restsocial.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vis.restsocial.model.Topic;
import vis.restsocial.repo.TopicRepo;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TopicController {

    @Autowired
    TopicRepo topicRepo;

    @RequestMapping(value = "/topic", method = RequestMethod.GET)
    public ResponseEntity<List<Topic>> listAllTopic() {
        List<Topic> listTopics = topicRepo.findAll();
        if (listTopics.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Topic>>(listTopics, HttpStatus.OK);

    }

    @RequestMapping(value = "/topic/", method = RequestMethod.POST)
    public Topic saveTopic(Topic topic){
        return topicRepo.save(topic);
    }

    @RequestMapping(value = "/topic/", method = RequestMethod.PUT)
    public ResponseEntity<Topic> updateTopic (@PathVariable(value = "id") Long topicId, @RequestBody Topic topicForm){
        Topic topic = topicRepo.getOne(topicId);
        if (topic == null){
            return ResponseEntity.notFound().build();
        }
        topic.setName(topicForm.getName());

        Topic updateTopic = topicRepo.save(topic);
        return ResponseEntity.ok(updateTopic);
    }

    @RequestMapping(value = "/topic/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Topic> deleteTopic(@PathVariable(value = "id") Long id){
        Topic topic = topicRepo.getOne(id);
        if(topic == null){
            return ResponseEntity.notFound().build();
        }
        topicRepo.delete(topic);
        return ResponseEntity.ok().build();
    }
}