package com.app.toDoApp.Controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.toDoApp.Entity.Task;
import com.app.toDoApp.Service.ToDoService;

@RestController
//@RequestMapping
public class ToDoController {
	
	private final ToDoService toDoService;
	
	public ToDoController(ToDoService toDoService) {
		this.toDoService=toDoService;
	}
	
	@GetMapping
	public String getTask(Model model) {
		List<Task> tasks = toDoService.getAllTasks();
		model.addAttribute( "todoitem", tasks);
		return "index";
	}
	
}
 