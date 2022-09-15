package it.pasqualecavallo.studentsmaterial.authorization_framework_example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import it.pasqualecavallo.studentsmaterial.authorization_framework.utils.Constants;

public class BaseTestIT {

	@LocalServerPort
	protected int port;
	
	@Autowired
	protected TestRestTemplate restTemplate;	
		
	protected String doLogin(String username) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("username", username);
		map.add("password", "password");
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
		ResponseEntity<Void> response = restTemplate.postForEntity("http://localhost:"+port+"/login", request, Void.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		return response.getHeaders().get(Constants.X_AUTHENTICATION_HEADER).get(0);
	}

}
