package com.app.toDoApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.toDoApp.Entity.Task;
import com.app.toDoApp.repository.TaskRepository;

@Service

public class ToDoService {
	
	@Autowired
	private TaskRepository taskRepository;

	public List<Task> getAllTasks() {
		
		return taskRepository.findAll();
	}
	
	
	public Task addItem(Task task) {
        return taskRepository.save(task);
    }
	
	public void deleteItem(Long id) {
		taskRepository.deleteById(id);
	}
	
	public Task toggleStatus(Long id) {
		Task item = taskRepository.findById(id).orElseThrow();
		item.setCompleted(!item.isCompleted());
		return taskRepository.save(item);
	}


//	public Task findAll() {
//		
//		return taskRepository.findAll();
//	}
}
