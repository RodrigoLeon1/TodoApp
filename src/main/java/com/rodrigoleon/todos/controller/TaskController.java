package com.rodrigoleon.todos.controller;

import com.rodrigoleon.todos.model.Task;
import com.rodrigoleon.todos.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Task>> findAll() {
        List<Task> tasks = taskService.findAll();
        System.out.println(tasks);
        return (tasks.size() > 0) ? ResponseEntity.ok(tasks) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
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
