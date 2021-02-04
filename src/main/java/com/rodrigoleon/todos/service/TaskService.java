package com.rodrigoleon.todos.service;

import com.rodrigoleon.todos.exception.task.TaskDoesNotExistException;
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

    public Task findById(Long id) throws TaskDoesNotExistException {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) throw new TaskDoesNotExistException();
        return task.get();
    }

    public void deleteById(Long id) throws TaskDoesNotExistException {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) throw new TaskDoesNotExistException();
        taskRepository.deleteById(id);
    }

    public Task updateById(Long id, Task updatedTask) throws TaskDoesNotExistException {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) throw new TaskDoesNotExistException();

        task.get().setTitle(updatedTask.getTitle());
        task.get().setCompleted(updatedTask.isCompleted());

        return taskRepository.save(task.get());
    }

}

