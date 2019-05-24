package com.datafoundry.sectionextractor.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.datafoundry.sectionextractor.services.SectionExtractorService;

@RestController
@RequestMapping("/api/v1/sectionextractor")
public class SectionExtractorController {
	@Autowired
	private SectionExtractorService sectionExtractorService;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping
	public String extractSections(@RequestParam("path") String path) {
		logger.info("PATH: " + path);
		return sectionExtractorService.extractSections(path);
	}
}
