package com.abcmover.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcmover.entity.Vessel;
import com.abcmover.exception.NoRecordFoundException;
import com.abcmover.exception.VesselNotFoundException;
import com.abcmover.repository.VesselRepository;

@Service
public class VesselService {
	
	@Autowired
	private VesselRepository vesselRepository;
	
	public List<Vessel> getAllVessel() {
		List<Vessel> vesselList = vesselRepository.findAll();
        
		if(vesselList.isEmpty()) {
			throw new NoRecordFoundException();
		} else if(vesselList.size() > 0) {
            return vesselList;
        } else {
            return new ArrayList<Vessel>();
        }
		
	}
	
	public Vessel getVesselById(Long id) {
		Optional<Vessel> vessel = vesselRepository.findById(id);
		if(vessel.isPresent())
			return vessel.get();
		else
			throw new VesselNotFoundException(id);
	}
	
	public Vessel createOrUpdateVessel(Vessel vesselEntity) throws NoRecordFoundException
    {
        Optional<Vessel> vessel = vesselRepository.findById(vesselEntity.getId());
        
        if(vessel.isPresent())
        {
        	Vessel newVessel = vessel.get();
        	newVessel.setVesselName(vesselEntity.getVesselName());
        	newVessel.setVesselCode(vesselEntity.getVesselCode());
        	newVessel.setActualArrivalTime(vesselEntity.getActualArrivalTime());
        	newVessel.setActualArrivalTime(vesselEntity.getActualArrivalTime());
 
        	newVessel = vesselRepository.save(newVessel);
             
            return newVessel;
        } else {
        	vesselEntity = vesselRepository.save(vesselEntity);
             
            return vesselEntity;
        }
    }
	
	public void deleteVesselById(Long id) {
        Optional<Vessel> vessel = vesselRepository.findById(id);
         
        if(vessel.isPresent())
        {
        	vesselRepository.deleteById(id);
        } else {
            throw new VesselNotFoundException(id);
        }
    }
	
}
