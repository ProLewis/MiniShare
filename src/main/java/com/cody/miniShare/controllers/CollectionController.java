package com.cody.miniShare.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cody.miniShare.models.Collection;
import com.cody.miniShare.models.Mini;
import com.cody.miniShare.models.Set;
import com.cody.miniShare.models.User;
import com.cody.miniShare.services.CollectionService;
import com.cody.miniShare.services.MiniService;
import com.cody.miniShare.services.SetService;
import com.cody.miniShare.services.UserService;

@Controller
public class CollectionController {

	@Autowired
	private CollectionService collectionServ;
	
	@Autowired 
	private SetService setServ;

	@Autowired
	private UserService userServ;
	
	@Autowired
	private MiniService miniServ;

	// Display Routes
	@GetMapping("/collections/new")
	public String create(Model model, HttpSession session, @ModelAttribute("collection") Collection collection) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		return "newCollection.jsp";
	}

	@GetMapping("/collections/{id}/edit")
	public String editCollection(@PathVariable("id") Long id, Model model, HttpSession session,
			@ModelAttribute("mini") Mini mini, @ModelAttribute("set") Set set) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		model.addAttribute("sets", setServ.getAll());
		model.addAttribute("collection", collectionServ.getOne(id));
		return "editCollection.jsp";
	}
	
	@GetMapping("/collections/{id}")
	public String showCollection(@PathVariable("id") Long id, Model model, HttpSession session, 
			@ModelAttribute("mini") Mini mini) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		model.addAttribute("collection", collectionServ.getOne(id));
		return "viewCollection.jsp";
	}
	
	@GetMapping ("/collections/{collId}/sets/{setId}")
	public String viewSet(@PathVariable("collId") Long collId, @PathVariable("setId") Long setId, Model model, HttpSession session) {
		if (session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		model.addAttribute("set", setServ.getOne(setId));
		model.addAttribute("collection", collectionServ.getOne(collId));
		return "set.jsp";
	}

	// Action Routes
	@PostMapping("/collections/create")
	public String createCollection(Model model, @Valid @ModelAttribute("collection") Collection collection,
			BindingResult result, HttpSession session) {
		if (session.getAttribute("uuid") == null) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			model.addAttribute("collections", collectionServ.getAll());
			return "newMini.jsp";
		}
		User user = userServ.getOne((Long) session.getAttribute("uuid"));
		collection.setCollectionCreator(user);
		collectionServ.save(collection);
		return "redirect:/minis";
	}
	
	@PostMapping("/collections/{collId}/sets/{miniId}/add")
	public String editCollection(@PathVariable("collId") Long collId, @PathVariable("miniId") Long miniId, Model model) {
		Collection collection = collectionServ.getOne(collId);
		Mini mini = miniServ.getOne(miniId);
		collection.getMinis().add(mini);
		collectionServ.save(collection);
		return "redirect:/collections/{collId}/sets/1";
	}
}
