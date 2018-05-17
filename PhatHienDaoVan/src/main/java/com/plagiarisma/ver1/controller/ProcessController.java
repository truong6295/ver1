package com.plagiarisma.ver1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plagiarisma.ver1.service.ProcessService;
import com.plagiarisma.ver1.until.ProcessString;

@RestController
@RequestMapping("/app")
public class ProcessController {
	@Autowired
	private ProcessService processService;
	
	@RequestMapping(value = "/getstring/{stringProcess}", method = RequestMethod.GET)
	public ResponseEntity<?> getstring(@PathVariable("stringProcess") String stringProcess) {
			List<ProcessString> list=processService.processStringInput(stringProcess);
			return new ResponseEntity<List<ProcessString>>(list, HttpStatus.OK); 
	}
}
