package com.datafoundry.sectionextractor.services;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.datafoundry.sectionextractor.utils.PreConditions;

@Service
public class SectionExtractorServiceImpl implements SectionExtractorService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public String extractSections(String filePath) {
		PreConditions.checkNotNull(filePath, "Filepath cannot be null");
		
		File file = new File(filePath);
		PreConditions.checkArgument(file.exists(), "File doesn't exist: " + filePath);
		String returnFileLength = String.valueOf(file.length());
		logger.info("file: " + filePath + " ---- size: " + returnFileLength);
		return returnFileLength;
	}
}
