package com.bohdan.todolist.repository;

import com.bohdan.todolist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

    //List<Task> findByUser(User user);
    //List<Task> findByProject(Project post);
}
