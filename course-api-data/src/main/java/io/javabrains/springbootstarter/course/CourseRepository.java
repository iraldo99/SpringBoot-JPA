package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{
	
	//find - By - Propiedad
	
	//public List<Course> getCoursesByTopic(String topicId); (nope)
	//public List<Course> findByName(String name);
	public List<Course> findByTopicId(String topicId);
	
}
