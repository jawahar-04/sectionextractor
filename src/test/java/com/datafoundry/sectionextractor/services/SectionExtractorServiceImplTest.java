package com.datafoundry.sectionextractor.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.datafoundry.sectionextractor.utils.InvalidInputException;

@SpringBootTest
class SectionExtractorServiceImplTest {
	@Autowired
	SectionExtractorServiceImpl sectionExtractorService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final String FILE_SIZE_STR = "53823";
	private final String TEST_FILE_NAME = "c:/dev/datafoundry/sectionextractor/src/main/resources/testdata/test.docx";
	private final String INVALID_FILE_NAME = "c:/dev/datafoundry/sectionextractor/src/main/resources/testdata/test.docx2";

	@Test
	void testExtractSections() {
		String s = sectionExtractorService.extractSections(TEST_FILE_NAME);
		logger.info("EXTRACTOR: " + s);
		assertTrue(s.equals(FILE_SIZE_STR));
		
	}
	
	@Test
	void testExtractSections_withNullFile() {
		assertThrows(InvalidInputException.class, () -> sectionExtractorService.extractSections(null));
	}
	
	@Test
	void testExtractSections_withInvalidFile() {
		assertThrows(InvalidInputException.class, () -> sectionExtractorService.extractSections(INVALID_FILE_NAME));
	}

}
