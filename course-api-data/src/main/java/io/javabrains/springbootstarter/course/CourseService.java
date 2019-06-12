package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javabrains.springbootstarter.topic.Topic;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
		new Topic("spring","Spring Framework","srpingdesc"),
		new Topic("java","Core Java","javadesc"),
		new Topic("javascript","JavaScript","jsdesc")
		)
	);
	
	public List<Course> getAllCourses(String topicId){
		//return courses;
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public Optional<Course> getCourse(String id) {
		//return courses.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		//stream filter busca, luego find first selecciona el primero y "get" de ese
		return courseRepository.findById(id);
	}

	public void addTopic(Course course) {
		//topics.add(course);
		courseRepository.save(course);
	}

	public void updateTopic(Course course) {
		/*for (int i = 0; i<courses.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				courses.set(i, course);
				return;
			}
		}*/
		
		courseRepository.save(course); //El save busca por defecto si la ID está repetida,
		//                             si lo está, lo updatea
		
	}

	public void deleteTopic(String id) {
		//courses.removeIf(t -> t.getId().contentEquals(id));
		
		courseRepository.deleteById(id);
		
	}
	
}
