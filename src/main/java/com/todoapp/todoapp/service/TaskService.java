package com.todoapp.todoapp.service;

import com.todoapp.todoapp.mapper.TaskInDTOToTask;
import com.todoapp.todoapp.persistence.TaskRepository;
import com.todoapp.todoapp.persistence.entity.Task;
import com.todoapp.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }
}
