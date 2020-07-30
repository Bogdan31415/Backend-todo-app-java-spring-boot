package com.bohdan.todolist.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {

    @Id
    Long taskId;
    String taskName;
    boolean status;
    @Enumerated
    private Prioritize prioritize;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "projectId", referencedColumnName = "projectId")
    private Project project;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;


}
