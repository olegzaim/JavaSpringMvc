//package com.em.service;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.em.model.Topic;
//import com.em.repository.TopicRepository;
//
//@Service
//public class TopicService {
//	
//	@Autowired
//	private TopicRepository topicRepository;
//
//	public List<Topic> getAllTopics() {
//		List<Topic> topics = new ArrayList<>();
//		topicRepository.findAll().forEach(topics::add);
//		return topics;
//	}
//
//	public Topic getTopic(Long id) {
//		return topicRepository.findById(id).get();
//	}
//
//	public void addTopic(Topic topic) {
//		topicRepository.save(topic);		
//	}
//
//	public void updateTopic(Long id, Topic topic) {
//		topicRepository.save(topic);
//	}
//	public void deleteTopic(Long id) {
//		topicRepository.deleteById(id);
//	}
//
//}
