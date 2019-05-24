package com.datafoundry.sectionextractor.services;

public interface SectionExtractorService {
	/**
	 * Takes in a file path pointing to a Word document
	 * Parses and returns the sections in the Word document
	 * @param filePath
	 * @return
	 */
	public String extractSections(String filePath);
}
