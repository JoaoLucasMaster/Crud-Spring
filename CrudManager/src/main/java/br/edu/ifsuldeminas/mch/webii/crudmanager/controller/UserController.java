package br.edu.ifsuldeminas.mch.webii.crudmanager.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.ifsuldeminas.mch.webii.crudmanager.dao.UserRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.User;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users")
	public String usuarios(Model model) {
		
		
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		return "index";
	}
	
	@GetMapping("")
	public String Index(Model model) {
		
		
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		return "index";
	}
	
	@GetMapping("/users/form")
	public String userForm(@ModelAttribute("user") User user) {
		
		
		return "user_form";
	}
	
	@PostMapping("/users/new")
	public String userNew(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
		{
			return "user_form";
		}
		
		userRepository.save(user);
		
		return"redirect:/users";
	}
	
	@GetMapping("/users/update/{id}")
	public String userUpdate(@PathVariable("id") Integer id, Model model)
	{
		
		Optional<User> optUser = userRepository.findById(id);
		if(!optUser.isPresent())
		{
			//Gerar erro
		}
		
		User user = optUser.get();
		
		model.addAttribute("user", user);
		
		return"user_form";
	}
	
	@GetMapping("/users/delete/{id}")
	public String userUpdate(@PathVariable("id") Integer id)
	{
		
		Optional<User> optUser = userRepository.findById(id);
		if(!optUser.isPresent())
		{
			//Gerar erro
		}
		
		User user = optUser.get();
		
		userRepository.delete(user);
		
		return"redirect:/users";
	}
}
