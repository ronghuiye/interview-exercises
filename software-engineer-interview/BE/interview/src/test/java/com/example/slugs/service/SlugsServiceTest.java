package com.example.slugs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.asurint.slugs.service.SlugsService;

class SlugsServiceTest {

	@InjectMocks
	SlugsService service;
	
	@BeforeEach
	public void before() {

		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void slugsGeneraterTest() {
		assertEquals(service.slugsGenerater("dd d d"),"dd-d-d");
		assertEquals(service.slugsGenerater("  dd d d"),"dd-d-d");
		assertEquals(service.slugsGenerater(" d d d d  "),"d-d-d-d");
		assertEquals(service.slugsGenerater("--dd -d d -"),"dd-d-d");
		assertEquals(service.slugsGenerater("??dd@ d d%"),"ddat-d-dpercent");
		assertEquals(service.slugsGenerater("dd-=+& d d"),"dd-and-d-d");
		assertEquals(service.slugsGenerater("dd---^* d d"),"dd-d-d");
	}

}
