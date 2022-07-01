package com.cody.miniShare.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cody.miniShare.models.Set;
import com.cody.miniShare.repositories.SetRepository;

@Service
public class SetService {
	
	@Autowired 
	private SetRepository setRepo;
	
	//Create set
	public Set save(Set newSet) {
		System.out.println(newSet.getSetName());
		return setRepo.save(newSet);
	}
	
	//Read
	public List<Set> getAll() {
		return setRepo.findAll();
	}
	
	public Set getOne(Long id) {
		Optional<Set> optName = setRepo.findById(id);
		if (optName.isPresent()) {
			return optName.get();
		} else {
			return null;
		}
	}
	
	//Delete
	public void delete(Long id) {
		setRepo.deleteById(id);
	}
}
