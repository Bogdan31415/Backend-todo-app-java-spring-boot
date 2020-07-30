package com.bohdan.todolist.controller;


import com.bohdan.todolist.dto.ProjectRequest;
import com.bohdan.todolist.dto.ProjectResponse;
import com.bohdan.todolist.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/project")
@AllArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Void> createProject(@RequestBody ProjectRequest projectRequest) {
        projectService.save(projectRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponse>> getAllProject() {
        return status(HttpStatus.OK).body(projectService.getAllProjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProject(@PathVariable Long id) {
        return status(HttpStatus.OK).body(projectService.getProject(id));
    }


    @GetMapping("by-user/{name}")
    public ResponseEntity<List<ProjectResponse>> getProjectByUsername(@PathVariable String name) {
        return status(HttpStatus.OK).body(projectService.getProjectsByUsername(name));
    }
}
