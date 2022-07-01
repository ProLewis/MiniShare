package com.cody.miniShare.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cody.miniShare.models.Mini;
import com.cody.miniShare.models.Set;
import com.cody.miniShare.services.MiniService;
import com.cody.miniShare.services.SetService;

@RestController
public class SetController {
	
	@Autowired
	private SetService setServ;
	
	@Autowired 
	private MiniService miniServ;
	
	
	@RequestMapping(value="/admin/set/create", method=RequestMethod.POST)
	public Set adminSetCreate(
			@RequestParam(value = "setName") String setName, 
			@RequestParam(value = "releaseDate") String releaseDate) {
		Set newSet = new Set();
		newSet.setSetName(setName);
		newSet.setReleaseDate(releaseDate);
		return setServ.save(newSet);
	}
	
	@RequestMapping(value="/admin/mini/create", method=RequestMethod.POST)
	public String adminMiniCreate(
			@RequestParam(value="name") String name,
			@RequestParam(value="size") String size,
			@RequestParam(value="painted") Boolean painted,
			@RequestParam(value="rarity") String rarity,
			@RequestParam(value="setNum") Integer setNum,
			@RequestParam(value="parentSet") Set parentSet) {
		Mini newMini = new Mini();
		newMini.setName(name);
		newMini.setSize(size);
		newMini.setPainted(painted);
		newMini.setRarity(rarity);
		newMini.setSetNum(setNum);
		newMini.setParentSet(parentSet);
		miniServ.save(newMini);
		return "Complete";
	}
	
	@RequestMapping(value="/admin/mini/edit/{id}", method=RequestMethod.PUT)
	public String adminMiniEdit(
			@PathVariable("id") Long id,
			@RequestParam(value="name") String name,
			@RequestParam(value="size") String size,
			@RequestParam(value="painted") Boolean painted,
			@RequestParam(value="rarity") String rarity,
			@RequestParam(value="setNum") Integer setNum,
			@RequestParam(value="parentSet") Set parentSet) {
		Mini updatedMini = miniServ.getOne(id);
		updatedMini.setName(name);
		updatedMini.setSize(size);
		updatedMini.setPainted(painted);
		updatedMini.setRarity(rarity);
		updatedMini.setSetNum(setNum);
		updatedMini.setParentSet(parentSet);
		miniServ.save(updatedMini);
		return "Updated";
	}

}
