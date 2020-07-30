package com.bohdan.todolist.service;


import com.bohdan.todolist.dto.ProjectRequest;
import com.bohdan.todolist.dto.ProjectResponse;
import com.bohdan.todolist.exceptions.ProjectNotFoundException;
import com.bohdan.todolist.mapper.ProjectMapper;
import com.bohdan.todolist.model.Project;
import com.bohdan.todolist.model.User;
import com.bohdan.todolist.repository.ProjectRepository;
import com.bohdan.todolist.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final ProjectMapper projectMapper;



    public void save(ProjectRequest projectRequest) {
        Project project = new Project();
        project.setProjectName(projectRequest.getProjectName());
        project.setUser(authService.getCurrentUser());
        projectRepository.save(project);

    }

    @Transactional(readOnly = true)
    public ProjectResponse getProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id.toString()));
        return projectMapper.mapToDto(project);
    }

    @Transactional(readOnly = true)
    public List<ProjectResponse> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::mapToDto)
                .collect(toList());
    }

    @Transactional(readOnly = true)
    public List<ProjectResponse> getProjectsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return projectRepository.findByUser(user)
                .stream()
                .map(projectMapper::mapToDto)
                .collect(toList());
    }
}
