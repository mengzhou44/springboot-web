package com.mengzhou44.firstweb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private static int todosCount = 3;

    private static List<Todo> todos = new ArrayList<>(List.of(
            new Todo(1, "in28minutes", "Learn AWS", LocalDate.now().plusYears(1), false),
            new Todo(2, "in28minutes", "Learn DevOps",
                    LocalDate.now().plusYears(2), false),
            new Todo(3, "in28minutes", "Learn Full Stack Development",
                    LocalDate.now().plusYears(3), false)

    ));

    public List<Todo> findByUsername(String username) {
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount,username,description,targetDate,done);
		todos.add(todo);
	}

}