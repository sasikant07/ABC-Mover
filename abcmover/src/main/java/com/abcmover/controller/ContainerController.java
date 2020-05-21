package com.abcmover.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abcmover.entity.Container;
import com.abcmover.exception.NoRecordFoundException;
import com.abcmover.service.ContainerService;

public class ContainerController {
	@Autowired
	private ContainerService containerService;
	
	@RequestMapping(value="/container", method = RequestMethod.GET)
	public List<Container> getContainer() {
		return containerService.getAllContainer();
	}
	
	@RequestMapping(value="/container/{id}", method = RequestMethod.GET)
	public ResponseEntity<Container> getContainerById(@PathVariable(value = "id") Long id) throws NoRecordFoundException {
		Container container = containerService.getContainerById(id);
		
		return new ResponseEntity<Container>(container, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/container/save", method = RequestMethod.POST)
	public ResponseEntity<Container> createOrUpdateContainer(Container container) {
		Container containerUpdated = containerService.createOrUpdateContainer(container);
		
		return new ResponseEntity<Container>(containerUpdated, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/container/delete/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteContainerById(@PathVariable("id") Long id) throws NoRecordFoundException {
		containerService.deleteContainerById(id);
		return HttpStatus.FORBIDDEN;
	}
}
