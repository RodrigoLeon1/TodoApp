package com.rodrigoleon.todos.controller;

import com.rodrigoleon.todos.model.Task;
import com.rodrigoleon.todos.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(final TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping("/")
    public Task create(@RequestBody @Valid final Task newTask){
        return taskService.create(newTask);
    }

    @GetMapping("/")
    public List<Task> findAll() {
        return taskService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Task> findById(@PathVariable final Long id) {
        return taskService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable final Long id) {
        taskService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Task updateById(@RequestBody @Valid final Task updatedTask,
                           @PathVariable final Long id) {
        return taskService.updateById(id, updatedTask);
    }

}
