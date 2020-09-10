package com.asurint.slugs.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asurint.slugs.entity.Slugs;
import com.asurint.slugs.repo.SlugsRepo;

@Service
public class SlugsService {
	
	@Autowired
	SlugsRepo repo;
	
	@Transactional
	public String processAndPersist(String url, String description) {
		//check url exists if needed
		String slugs = slugsGenerater(description);
		Slugs i = new Slugs();
		i.setUrl(url);
		i.setDescription(slugs);
		repo.save(i);
		
		return slugs;
	}
	
	public String getUrlBySlugs(String slugs) {
		Slugs i = repo.findOneByDescription(slugs);
		if(i != null) {
			return i.getUrl();
		}
		return "";
	}

	public String slugsGenerater(String str) {
		String filteredStr = str.replaceAll("-", " ")
				.trim()
				.toLowerCase()
				.replaceAll("[^a-z&@% ]", "")
				.replaceAll("&", "and")
				.replaceAll("@", "at")
				.replaceAll("%", "percent");
		
		boolean isPreviousSpace = false;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < filteredStr.length(); i++) {
			if (filteredStr.charAt(i) != ' ') {
				sb.append(filteredStr.charAt(i));
				isPreviousSpace = false;
			} else if (!isPreviousSpace) {
				sb.append('-');
				isPreviousSpace = true;
			}
		}
		return sb.toString();
	}
}
