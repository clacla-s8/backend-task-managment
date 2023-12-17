package com.brickup.taskManagment.service;

import com.brickup.taskManagment.model.Task;
import com.brickup.taskManagment.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task create(String name, String description, MultipartFile imageFile, boolean status) {
        Task task = new Task();

        String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a a valid file");
        }
        try {
            task.setImage(Base64.getEncoder().encodeToString(imageFile.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        task.setName(name);
        task.setDescription(description);
        task.setStatus(status);
        return taskRepository.save(task);

    }

    public Optional<Task> getById(Long id) {
        return taskRepository.findById(id);
    }

    public Task update(Long id, Task updatedTask) {
        if (taskRepository.existsById(id)) {
            updatedTask.setId(id);
            return taskRepository.save(updatedTask);
        } else {
            throw new RuntimeException("Task not found with id: " + id);
        }
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }


}
