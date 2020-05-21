package com.abcmover.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.abcmover.entity.Vessel;
import com.abcmover.exception.NoRecordFoundException;
import com.abcmover.service.VesselService;

public class VesselController {
	
	@Autowired
	private VesselService vesselService;
	
	@RequestMapping(value="/vessel", method = RequestMethod.GET)
	public List<Vessel> getVessel() {
		return vesselService.getAllVessel();
	}
	
	@RequestMapping(value="/vessel/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vessel> getVesselById(@PathVariable(value = "id") Long id) throws NoRecordFoundException {
		Vessel vessel = vesselService.getVesselById(id);
		
		return new ResponseEntity<Vessel>(vessel, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/vessel/save", method = RequestMethod.POST)
	public ResponseEntity<Vessel> createOrUpdateVessel(Vessel vessel) {
		Vessel vesselUpdated = vesselService.createOrUpdateVessel(vessel);
		
		return new ResponseEntity<Vessel>(vesselUpdated, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/vessel/delete/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteVesselById(@PathVariable("id") Long id) throws NoRecordFoundException {
		vesselService.deleteVesselById(id);
		return HttpStatus.FORBIDDEN;
	}
}
