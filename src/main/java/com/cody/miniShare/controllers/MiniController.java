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

import com.cody.miniShare.models.User;
import com.cody.miniShare.models.Collection;
import com.cody.miniShare.models.Mini;
import com.cody.miniShare.models.Set;
import com.cody.miniShare.services.CollectionService;
import com.cody.miniShare.services.MiniService;
import com.cody.miniShare.services.SetService;
import com.cody.miniShare.services.UserService;

@Controller
public class MiniController {
	
	@Autowired
	private MiniService miniServ;
	
	@Autowired
	private UserService userServ;
	
	@Autowired 
	private SetService setServ;
	
	@Autowired
	private CollectionService collectionServ;
	
	//Display Routes
	@GetMapping("/minis")
	public String dashboard(Model model, HttpSession session, @ModelAttribute("collection") Collection collection) {
		if (session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		model.addAttribute("user", userServ.getOne((Long)session.getAttribute("uuid")));
		model.addAttribute("collections", collectionServ.getAll());
		return "dashboard.jsp";
	}
	
	@GetMapping("/minis/new")
	public String create(Model model, HttpSession session, @ModelAttribute("mini") Mini mini) {
		if (session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		return "newMini.jsp";
	}
	
	@GetMapping("/sets")
	public String viewSets(Model model, HttpSession session, @ModelAttribute("set") Set set) {
		if (session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		model.addAttribute("sets", setServ.getAll());
		return "sets.jsp";
	}
	
	@GetMapping ("/sets/{id}")
	public String viewSet(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		model.addAttribute("set", setServ.getOne(id));
		return "set.jsp";
	}
	
	//Action Routes
	@PostMapping("minis/create")
	public String createMini(Model model, @Valid @ModelAttribute("mini") Mini mini, BindingResult result, HttpSession session) {
		if (session.getAttribute("uuid")==null) {
			return "redirect:/";
		}
		if (result.hasErrors()) {
			model.addAttribute("names", miniServ.getAll());
			return "newMini.jsp";
		}
		User user = userServ.getOne((Long) session.getAttribute("uuid"));	
		mini.setCreator(user);
		miniServ.save(mini);
		return "redirect:/minis";
	}
	
	
	
}
