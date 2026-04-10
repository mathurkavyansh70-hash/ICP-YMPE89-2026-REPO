package com.example.DataJpaAPI.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.DataJpaAPI.Entity.Task;
import com.example.DataJpaAPI.Service.TaskService;
import java.util.List;
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping("/user/{userId}/category/{categoryId}")
    public Task createTask(@PathVariable Long userId,
                           @PathVariable Long categoryId,
                           @RequestBody Task task) {
        return service.createTask(userId, categoryId, task);
    }

    @GetMapping("/user/{userId}")
    public List<Task> getTasksByUser(@PathVariable Long userId) {
        return service.getTasksByUser(userId);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable boolean status) {
        return service.getCompletedTasks(status);
    }
}
