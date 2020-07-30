package com.bohdan.todolist.service;

import com.bohdan.todolist.dto.TaskRequest;
import com.bohdan.todolist.mapper.ProjectMapper;
import com.bohdan.todolist.model.Task;
import com.bohdan.todolist.repository.TaskRepository;
import com.bohdan.todolist.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final ProjectMapper projectMapper;



    public void save(TaskRequest taskRequest) {
        Task task = new Task();
        task.setTaskName(taskRequest.getTaskName());
        task.setUser(authService.getCurrentUser());
        taskRepository.save(task);

    }


}


