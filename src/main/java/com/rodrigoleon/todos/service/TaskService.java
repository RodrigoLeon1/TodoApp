package com.rodrigoleon.todos.service;

import com.rodrigoleon.todos.model.Task;
import com.rodrigoleon.todos.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(final TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public Task create(Task newTask) {
        return taskRepository.save(newTask);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateById(Long id, Task updatedTask) {
        return taskRepository.save(updatedTask);
    }

}
