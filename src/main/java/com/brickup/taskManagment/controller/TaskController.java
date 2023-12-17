package com.brickup.taskManagment.controller;

import com.brickup.taskManagment.model.Task;
import com.brickup.taskManagment.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("tasks")
public class TaskController {


    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestParam("name") String name, @RequestParam("description") String description,
                           @RequestParam("image") MultipartFile imageFile,
                           @RequestParam("status") boolean status) {
        return taskService.create(name, description, imageFile, status);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return taskService.update(id, updatedTask);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAll();

    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id) {
        return taskService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.delete(id);
    }
}
