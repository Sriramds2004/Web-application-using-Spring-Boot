package com.in28minsSpringBoot.MyFirstWebApp.todo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class ToDoController {
	
	
	public ToDoController(ToDoService toDoService) {
		super();
		this.toDoService = toDoService;
	}

	public ToDoService toDoService ;
	
	
	@RequestMapping("list-todos")
	public String ListAllToDos(ModelMap model) {
		String username = getLoggedInUsername(model);
		List<ToDo> todos = toDoService.findByUsername(username);
		model.addAttribute("todos",todos);
		return "listToDos";
	}

	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String ShowNewToDoPage() {
	
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewToDo(@RequestParam String description, ModelMap model,@Valid ToDo todo, BindingResult result) {
		System.out.println(description);
	    String username = getLoggedInUsername(model);
	    toDoService.addToDo(username, description, todo.getTargetDate(), false);
	    return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteToDo(@RequestParam int id) {
		toDoService.deleteById(id);
		   return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpDatePage(@RequestParam int id,ModelMap model) {
		  ToDo todo = toDoService.findById(id);
		  model.addAttribute("todo",todo);
		   return "todo";
	} 
	
	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid ToDo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		toDoService.updateTodo(todo);
		return "redirect:list-todos";
	}

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}



}
