package com.in28minsSpringBoot.MyFirstWebApp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo,Integer> {
	public List<ToDo> findByUsername(String username);
}
