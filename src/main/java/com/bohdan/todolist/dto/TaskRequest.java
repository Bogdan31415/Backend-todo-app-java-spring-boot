package com.bohdan.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    private String taskName;
    private boolean status;
    private String  prioritize;
}
