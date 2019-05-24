package com.datafoundry.sectionextractor.controllers;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class SectionExtractorControllerIntegrationTest {
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	private final String FILE_SIZE_STR = "53823";
	private final String TEST_FILE_NAME = "c:/dev/datafoundry/sectionextractor/src/main/resources/testdata/test.docx";
	
	
	@Test
	void testExtractSections() {
		System.out.println("------ testExtractSections ----------");
		String url = "/api/v1/sectionextractor?path=" + TEST_FILE_NAME;
		HttpEntity<String> sectionEntity = new HttpEntity<String>(null, new HttpHeaders());
		ResponseEntity<String> sectionsStrResponse = restTemplate.exchange(url, HttpMethod.GET, sectionEntity, String.class);
		assertNotNull(sectionsStrResponse);
		assertTrue(sectionsStrResponse.getStatusCode().equals(HttpStatus.OK), "response status code should be HttpStatus.OK");
		assertTrue(sectionsStrResponse.getBody().equals(FILE_SIZE_STR));
	}

}
