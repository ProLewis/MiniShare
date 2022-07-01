package com.cody.miniShare.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cody.miniShare.models.Collection;
import com.cody.miniShare.repositories.CollectionRepository;

@Service
public class CollectionService {
	
	@Autowired
	private CollectionRepository collectionRepo;
	
	//Create collection
	public Collection save(Collection newCollection) {
		return collectionRepo.save(newCollection);
	}
	
	//Read
	public List<Collection> getAll() {
		return collectionRepo.findAll();
	}
	
	public Collection getOne(Long id) {
		Optional<Collection> optName = collectionRepo.findById(id);
		if (optName.isPresent()) {
			return optName.get();
		} else {
			return null;
		}
	}
	
	
	//Delete
	public void delete(Long id) {
		collectionRepo.deleteById(id);
	}
}
