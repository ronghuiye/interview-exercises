package com.asurint.interview.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asurint.interview.entity.Interview;
import com.asurint.interview.repo.InterviewRepo;

@Service
public class InterviewService {
	
	@Autowired
	InterviewRepo interviewRepo;
	
	@Transactional
	public String processAndPersist(String url, String description) {
		
		String slugs = slugsGenerater(description);
		Interview i = new Interview();
		i.setUrl(url);
		i.setDescription(slugs);
		interviewRepo.save(i);
		
		return slugs;
	}
	
	public String getUrlBySlugs(String slugs) {
		Interview i = interviewRepo.findOneByDescription(slugs);
		if(i != null) {
			return i.getUrl();
		}
		return "";
	}

	private String slugsGenerater(String str) {
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
