package it.pasqualecavallo.studentsmaterial.authorization_framework_example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import it.pasqualecavallo.studentsmaterial.authorization_framework.utils.Constants;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PublicEndpointTestIT extends BaseTestIT {

	/**
	 * - No authentication - @PublicEndpoint on the handling method
	 */
	@Test
	public void testPublicEndpoint() {
		ResponseEntity<Void> response = restTemplate.getForEntity("http://localhost:" + port + "/public-endpoint",
				Void.class);
		assertTrue(response.getStatusCode().equals(HttpStatus.OK));
	}

	@Test
	public void testPublicEndpointFullyAuthenticatedWithNoRole() throws URISyntaxException {
		String jws = doLogin("norole");
		HttpHeaders headers = new HttpHeaders();
		headers.add(Constants.X_AUTHENTICATION_HEADER, jws);
		RequestEntity<Void> request = new RequestEntity<Void>(headers, HttpMethod.GET,
				new URI("http://localhost:" + port + "/public-endpoint"));
		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
		assertTrue(response.getStatusCode().equals(HttpStatus.OK));
	}

	@Test
	public void testPublicEndpointFullyAuthenticated() throws URISyntaxException {
		String jws = doLogin("admin");
		HttpHeaders headers = new HttpHeaders();
		headers.add(Constants.X_AUTHENTICATION_HEADER, jws);
		RequestEntity<Void> request = new RequestEntity<Void>(headers, HttpMethod.GET,
				new URI("http://localhost:" + port + "/public-endpoint"));
		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
		assertTrue(response.getStatusCode().equals(HttpStatus.OK));
	}

}
