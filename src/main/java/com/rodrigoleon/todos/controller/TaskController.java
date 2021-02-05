package com.rodrigoleon.todos.controller;

import com.rodrigoleon.todos.exception.task.TaskDoesNotExistException;
import com.rodrigoleon.todos.model.Task;
import com.rodrigoleon.todos.service.TaskService;
import com.rodrigoleon.todos.utils.RestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(final TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping("/")
    public ResponseEntity<Task> create(@RequestBody @Valid final Task newTask){
        // Validate title...
        Task task = taskService.create(newTask);
        return ResponseEntity.created(RestUtils.getLocation(task.getId())).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Task>> findAll() {
        List<Task> tasks = taskService.findAll();
        return (tasks.size() > 0) ? ResponseEntity.ok(tasks) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable final Long id) throws TaskDoesNotExistException {
        Task task = taskService.findById(id);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteById(@PathVariable final Long id) throws TaskDoesNotExistException {
        taskService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateById(@RequestBody final Task updatedTask,
                                           @PathVariable final Long id) throws TaskDoesNotExistException {
        Task task = taskService.updateById(id, updatedTask);
        return ResponseEntity.ok(task);
    }

}
