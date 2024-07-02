package com.thirdParty.service;

import java.util.List;
import java.util.Map;

public interface PostService {
	
	List<Map<String, Object>> getPost();
	
	Object getPostById(Integer id);
	
	Map<String, Object> insertPost(Map<String, Object> payload);
	
	Map<String, Object> updatePost(Integer id, Map<String, Object> payload);

}
