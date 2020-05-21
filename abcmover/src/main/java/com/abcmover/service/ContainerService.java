package com.abcmover.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcmover.entity.Container;
import com.abcmover.exception.ContainerNotFoundException;
import com.abcmover.exception.NoRecordFoundException;
import com.abcmover.repository.ContainerRepository;

@Service
public class ContainerService {
	
	@Autowired
	private ContainerRepository containerRepository; 
	
	public List<Container> getAllContainer() {
		List<Container> containerList = containerRepository.findAll();
        
		if(containerList.isEmpty()) {
			throw new NoRecordFoundException();
		} else if(containerList.size() > 0) {
            return containerList;
        } else {
            return new ArrayList<Container>();
        }
		
	}
	
	public Container getContainerById(Long id) {
		Optional<Container> container = containerRepository.findById(id);
		if(container.isPresent())
			return container.get();
		else
			throw new ContainerNotFoundException(id);
	}
	
	public Container createOrUpdateContainer(Container containerEntity) throws NoRecordFoundException
    {
        Optional<Container> container = containerRepository.findById(containerEntity.getId());
         
        if(container.isPresent())
        {
        	Container newContainer = container.get();
        	newContainer.setContainerNumber(containerEntity.getContainerNumber());
        	newContainer.setContainerISOCode(containerEntity.getContainerISOCode());
        	newContainer.setContainerFullOrEmpty(containerEntity.isContainerFullOrEmpty());
        	newContainer.setContainerType(containerEntity.getContainerType());
        	
        	newContainer = containerRepository.save(newContainer);
             
            return newContainer;
        } else {
        	containerEntity = containerRepository.save(containerEntity);
             
            return containerEntity;
        }
    }
	
	public void deleteContainerById(Long id) {
        Optional<Container> container = containerRepository.findById(id);
         
        if(container.isPresent())
        {
        	containerRepository.deleteById(id);
        } else {
            throw new ContainerNotFoundException(id);
        }
    }
}
