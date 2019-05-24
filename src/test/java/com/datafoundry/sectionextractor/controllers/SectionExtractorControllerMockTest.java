package com.datafoundry.sectionextractor.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.datafoundry.sectionextractor.services.SectionExtractorService;

public class SectionExtractorControllerMockTest {
	
	// To test the SectionExtractorController mock the service object which is contained in the controller
	@Mock
	SectionExtractorService sectionExtractorService;
	
	// This will initiate the Controller and inject the appropriate mocks (in this case sectionExtractorService)
	@InjectMocks
	SectionExtractorController sectionExtractorController;
	
	private final String FILE_SIZE_STR = "53823";
	private final String TEST_FILE_NAME = "c:/dev/datafoundry/sectionextractor/src/main/resources/testdata/test.docx";
	
	
	@BeforeEach
	public void setUp() throws Exception {
		// initialize the mock objects i.e. SectionExtractorController will be created and the mock service will be injected inside the controller
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testExtractSections() {
		// when the service (sectionExtractorService) is called with a method (extractSections)
		// then return the appropriate String object
		// since we are mocking the argument for extractSections(String path) is not important hence passing in anyString()
		when(sectionExtractorService.extractSections(anyString())).thenReturn(FILE_SIZE_STR);
		
		// Now call the controller (which will in turn use the Mock Service)
		String sectionExtractorStr = sectionExtractorController.extractSections(TEST_FILE_NAME);
		assertNotNull(sectionExtractorStr);
		assertTrue(sectionExtractorStr.equals(FILE_SIZE_STR));
	}

}
