package com.abcmover.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abcmover.entity.ShippingLine;
import com.abcmover.exception.NoRecordFoundException;
import com.abcmover.service.ShippingLineService;

@RestController
public class ShippingLIneController {
	
	@Autowired
	private ShippingLineService shippingLineService;
	
	@RequestMapping(value="/shippingLine", method = RequestMethod.GET)
	public List<ShippingLine> getShippingLine() {
		return shippingLineService.getAllShippingLine();
	}
	
	@RequestMapping(value="/shippingLine/{id}", method = RequestMethod.GET)
	public ResponseEntity<ShippingLine> getShippingLineById(@PathVariable(value = "id") Long id) throws NoRecordFoundException {
		ShippingLine shippingLine = shippingLineService.getShippingLineById(id);
		
		return new ResponseEntity<ShippingLine>(shippingLine, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/shippingLine/save", method = RequestMethod.POST)
	public ResponseEntity<ShippingLine> createOrUpdateShippingLine(ShippingLine shippingLine) {
		ShippingLine shippingLineUpdated = shippingLineService.createOrUpdateShippingLine(shippingLine);
		
		return new ResponseEntity<ShippingLine>(shippingLineUpdated, new HttpHeaders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/shippingLine/delete/{id}", method = RequestMethod.DELETE)
	public HttpStatus deleteShippingLineById(@PathVariable("id") Long id) throws NoRecordFoundException {
		shippingLineService.deleteShippingLineById(id);
		return HttpStatus.FORBIDDEN;
	}
}
