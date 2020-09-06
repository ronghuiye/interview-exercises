package com.asurint.interview.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asurint.interview.BaseResponse;
import com.asurint.interview.service.InterviewService;

@RestController
public class InterviewController {

	@Autowired
	InterviewService interviewService;
	
	@PostMapping(path = "/api/step2")
	public ResponseEntity<BaseResponse> addSlugsRecord(@RequestBody RequestMapping mapping){
		BaseResponse response = new BaseResponse();
		try {
			String slugs = interviewService.processAndPersist(mapping.getUrl(), mapping.getDescription());
			response.setStatus(200);
			response.setSuccess(true);
			response.setMessage(slugs);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}catch(Exception e) {
			response.setStatus(400);
			response.setSuccess(false);
			response.setMessage(e.getMessage());
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(path = "/api/step3")
	public void addSlugsRecord2(HttpServletResponse httpServletResponse, @RequestBody SlugsMapping mapping){
		String url = interviewService.getUrlBySlugs(mapping.getSlugs());
		httpServletResponse.setHeader("Location", url);
	    httpServletResponse.setStatus(302);
	}
	
}
