package com.abcmover.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcmover.entity.ShippingLine;
import com.abcmover.exception.NoRecordFoundException;
import com.abcmover.exception.ShippingLineNotFoundException;
import com.abcmover.repository.ShippingLineRepository;

@Service
public class ShippingLineService {
	
	@Autowired
	private ShippingLineRepository shippingLineRepository;
	
	public List<ShippingLine> getAllShippingLine() {
		List<ShippingLine> shippingLineList = shippingLineRepository.findAll();
        
		if(shippingLineList.isEmpty()) {
			throw new NoRecordFoundException();
		} else if(shippingLineList.size() > 0) {
            return shippingLineList;
        } else {
            return new ArrayList<ShippingLine>();
        }
		
	}
	
	public ShippingLine getShippingLineById(Long id) {
		Optional<ShippingLine> shippingLine = shippingLineRepository.findById(id);
		if(shippingLine.isPresent())
			return shippingLine.get();
		else
			throw new ShippingLineNotFoundException(id);
	}
	
	public ShippingLine createOrUpdateShippingLine(ShippingLine shippingLineEntity) throws NoRecordFoundException
    {
        Optional<ShippingLine> shippingLine = shippingLineRepository.findById(shippingLineEntity.getId());
         
        if(shippingLine.isPresent())
        {
        	ShippingLine newShippingLine = shippingLine.get();
        	newShippingLine.setShippingLineName(shippingLineEntity.getShippingLineName());
        	newShippingLine.setLineCode(shippingLineEntity.getLineCode());
        	newShippingLine.setDescription(shippingLineEntity.getDescription());
 
            newShippingLine = shippingLineRepository.save(newShippingLine);
             
            return newShippingLine;
        } else {
        	shippingLineEntity = shippingLineRepository.save(shippingLineEntity);
             
            return shippingLineEntity;
        }
    }
	
	public void deleteShippingLineById(Long id) {
        Optional<ShippingLine> shippingLine = shippingLineRepository.findById(id);
         
        if(shippingLine.isPresent())
        {
        	shippingLineRepository.deleteById(id);
        } else {
            throw new ShippingLineNotFoundException(id);
        }
    }
}
