package com.in28minsSpringBoot.MyFirstWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class ToDoService {
	
	private static List<ToDo> todos = new ArrayList<>();
	private static int toDosCount=0;
	static {
		todos.add(new ToDo(++toDosCount,"in28mins","Learn Spring1",LocalDate.now().plusYears(1),false));
		todos.add(new ToDo(++toDosCount,"in28mins","Learn SpringBoot1",LocalDate.now().plusYears(2),false));
		todos.add(new ToDo(++toDosCount,"in28mins","Learn SpringSecurity1",LocalDate.now().plusYears(3),false));
	}

	public List<ToDo> findByUsername(String username){
		Predicate<? super ToDo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username) ;
		return todos.stream().filter(predicate).toList();
	}

	public void addToDo(String username, String description,LocalDate targetDate, boolean done ) {
		ToDo todo = new ToDo(++toDosCount,username,description,targetDate,done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<? super ToDo> predicate = todo-> todo.getId()==id;
		todos.removeIf(predicate  );
	}

	public ToDo findById(int id) {
		Predicate<? super ToDo> predicate = todo -> todo.getId()==id;
		ToDo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid ToDo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}

    

}

