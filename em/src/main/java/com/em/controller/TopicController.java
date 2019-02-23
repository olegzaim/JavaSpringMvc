//package com.em.controller;
//
//import java.lang.reflect.Array;
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.em.model.Topic;
//import com.em.service.TopicService;
//
//@RestController
//public class TopicController {
//	
//	@Autowired
//	private TopicService topicService;
//	
//	@RequestMapping("/topics")
//	public List<Topic> getAllTopics() {
//		return topicService.getAllTopics();
//				
//	}
//	
//	@RequestMapping("/topics/{id}")
//	public Topic getTopic(@PathVariable Long id) {
//		return topicService.getTopic(id);
//		
//	}
//	
//	@RequestMapping(method = RequestMethod.POST ,value="/topics")
//	public void addTopic(@RequestBody Topic topic) {
//		topicService.addTopic(topic);
//		
//	}
//	
//	@RequestMapping(method = RequestMethod.PUT,value="/topics/{id}")
//	public void updateTopic(@RequestBody Topic topic, @PathVariable Long id) {
//		topicService.updateTopic(id,topic);
//	}
//	
//	@RequestMapping(method = RequestMethod.DELETE, value="/topics/{id}")
//	public void deleteTopic(@PathVariable Long id) {
//		topicService.deleteTopic(id);
//	}
//
//}
