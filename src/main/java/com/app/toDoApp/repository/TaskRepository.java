package com.app.toDoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.toDoApp.Entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

}
