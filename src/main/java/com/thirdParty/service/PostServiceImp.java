package com.thirdParty.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostServiceImp implements PostService{
	
	@Autowired
    private RestTemplate restTemplate;
    
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final String POSTS_ENDPOINT = "/posts";
    

    @Override
    public List<Map<String, Object>> getPost() {
        HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());
        String url = BASE_URL + POSTS_ENDPOINT;
        ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                url, 
                HttpMethod.GET, 
                httpEntity, 
                new ParameterizedTypeReference<List<Map<String, Object>>>() {}
        );

        return response.getBody();
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

	@Override
	public Object getPostById(Integer id) {
		 HttpEntity<Void> httpEntity = new HttpEntity<>(getHttpHeaders());
		 String url = BASE_URL + POSTS_ENDPOINT+"/"+id;
		 var response= restTemplate.exchange(
	        		url,
	        		HttpMethod.GET,
	        		httpEntity,
	        		new ParameterizedTypeReference<Object>() {}
	        );
	        
		return response.getBody();
	}

	@Override
	public Map<String, Object> insertPost(Map<String, Object> payload) {
	    HttpEntity<Object> httpEntity = new HttpEntity<>(payload, getHttpHeaders());
	    
	    String url = BASE_URL + POSTS_ENDPOINT;
	    
	    ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
	            url,
	            HttpMethod.POST,
	            httpEntity,
	            new ParameterizedTypeReference<Map<String, Object>>() {}
	    );
	    
	    return response.getBody();
	}
	
	@Override
	public Map<String, Object> updatePost(Integer id, Map<String, Object> payload) {
	    HttpEntity<Object> httpEntity = new HttpEntity<>(payload, getHttpHeaders());
	    
	    String url = BASE_URL + POSTS_ENDPOINT+"/"+id;
	    
	    ResponseEntity<Map<String, Object>> response = restTemplate.exchange(
	            url,
	            HttpMethod.PUT,
	            httpEntity,
	            new ParameterizedTypeReference<Map<String, Object>>() {}
	    );
	    
	    return response.getBody();
	}



}
