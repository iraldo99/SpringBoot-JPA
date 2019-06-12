package io.javabrains.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	/* GET */
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getCourse(@PathVariable String id) { 
		return topicService.getTopics(id);
	}
	
	/* POST */
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addCourse(@RequestBody Topic topic) { // Recoge el body "json" y lo transforma en un Topic
		topicService.addTopic(topic);
	}
	
	/* UPDATE */
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateCourse(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(topic, id);
	}
	
	/* DELETE */
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteCourse(@PathVariable String id) { 
		topicService.deleteTopic(id);
	}
	
}
