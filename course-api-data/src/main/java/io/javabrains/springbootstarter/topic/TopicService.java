package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
		new Topic("spring","Spring Framework","srpingdesc"),
		new Topic("java","Core Java","javadesc"),
		new Topic("javascript","JavaScript","jsdesc")
		)
	);
	
	public List<Topic> getAllTopics(){
		//return courses;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Topic> getTopics(String id) {
		//return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		//stream filter busca, luego find first selecciona el primero y "get" de ese
		return topicRepository.findById(id);
	}

	public void addTopic(Topic topic) {
		//topics.add(course);
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String id) {
		/*for (int i = 0; i<topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}*/
		
		topicRepository.save(topic); //El save busca por defecto si la ID está repetida,
		//                             si lo está, lo updatea
	}

	public void deleteTopic(String id) {
		//courses.removeIf(t -> t.getId().contentEquals(id));
		
		topicRepository.deleteById(id);
		
	}
	
}
