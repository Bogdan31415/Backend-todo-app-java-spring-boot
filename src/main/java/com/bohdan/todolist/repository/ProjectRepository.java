package com.bohdan.todolist.repository;

import com.bohdan.todolist.model.Project;
import com.bohdan.todolist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

     List<Project> findByUser(User user);
}
