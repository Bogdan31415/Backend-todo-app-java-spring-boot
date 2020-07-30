package com.bohdan.todolist.mapper;

import com.bohdan.todolist.dto.ProjectResponse;
import com.bohdan.todolist.model.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mapping(target = "id", source = "projectId")
    @Mapping(target = "projectName", source = "projectName")
    @Mapping(target = "userName", source = "user.username")
    ProjectResponse mapToDto(Project project);
}
