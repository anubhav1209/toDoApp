package com.app.toDoApp.Controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.app.toDoApp.Entity.Task;
import com.app.toDoApp.Service.ToDoService;


@RestController
@RequestMapping("api/todos")
public class ToDoController {
	
	private final ToDoService toDoService;
	
	public ToDoController(ToDoService toDoService) {
		this.toDoService=toDoService;
	}
	
	@GetMapping
	public String getTask(Model model) {
		List<Task> tasks = toDoService.getAllTasks();
		model.addAttribute( "tasks", tasks);
		return "tasks";
	}
	
	@PostMapping
	public Task create(@RequestBody Task Task) {
		return toDoService.addItem(Task);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		toDoService.deleteItem(id);
		
	}
	
	@PutMapping("/{id}/toggle")
	public Task toggle(@PathVariable Long id) {
		return toDoService.toggleStatus(id);
	}
	
}
 