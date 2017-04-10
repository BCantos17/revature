package com.revature.rest.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.revature.beans.Trainee;

/**
 * Service that inerfaces with Patricks Trainee API (C) Reavture
 *
 */
public class TraineeApi {
	
	private String POST_URL = "http://10.255.184.248:9001/spring-rest/trainee/";
	private String GET_URL = "http://10.255.184.248:9001/spring-test/trainee/all/";
	
	private RestTemplate rest = new RestTemplate();
	public void insert (Trainee trainee){
		ResponseEntity<Trainee> response = rest.postForEntity(POST_URL, trainee, Trainee.class);
		if(response.getStatusCode() == HttpStatus.OK){
			System.out.println("insert successful");
		}
		if(response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR){
			System.out.println("insert failed");
		}
		else{
			System.out.println(response.getStatusCode());
		}
	
	}
	public Trainee get(int id){
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(POST_URL).path(String.valueOf(id));
		String URI = builder.build().toUriString();
		ResponseEntity<Trainee> response = rest.getForEntity(POST_URL, Trainee.class);
		if(response.getStatusCode() == HttpStatus.NOT_FOUND){
			return null;
		}
		else{
			return response.getBody();
		}
	}
	private List<Trainee> getAll() {
		ResponseEntity<Trainee[]> responseEntity = rest.getForEntity(GET_URL, Trainee[].class);
		return Arrays.asList(responseEntity.getBody());
	}
	
	public void update(Trainee trainee){
		try {
			ResponseEntity<Trainee> response = rest.exchange( 
					new URI(POST_URL), 
					HttpMethod.PUT,
					new HttpEntity<Trainee>(trainee), 
					Trainee.class);
			
			if (response.getStatusCode() == HttpStatus.NO_CONTENT){
				System.out.println("Update successful");
			}
			if(response.getStatusCode() == HttpStatus.BAD_REQUEST)
				throw new IllegalArgumentException("Bad request");
				
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
