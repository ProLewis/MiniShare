package com.cody.miniShare.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cody.miniShare.models.Mini;
import com.cody.miniShare.repositories.MiniRepository;

@Service
public class MiniService {
	
	@Autowired
	private MiniRepository miniRepo;
	
	//Create mini
	public Mini save(Mini newMini) {
		return miniRepo.save(newMini);
	}
	
	//Read
	public List<Mini> getAll() {
		return miniRepo.findAll();
	}
	
	public Mini getOne(Long id) {
		Optional<Mini> optName = miniRepo.findById(id);
		if (optName.isPresent()) {
			return optName.get();
		} else {
			return null;
		}
	}
	
	//Delete
	public void delete(Long id) {
		miniRepo.deleteById(id);
	}
}
