package com.example.DataJpaAPI.Service;

import org.springframework.stereotype.Service;

import com.example.DataJpaAPI.Entity.*;
import com.example.DataJpaAPI.Repository.CategoryRepository;
import com.example.DataJpaAPI.Repository.TaskRepository;
import com.example.DataJpaAPI.Repository.UserRepository;
import java.util.List;
@Service
public class TaskService {

    private final TaskRepository taskRepo;
    private final UserRepository userRepo;
    private final CategoryRepository categoryRepo;

    public TaskService(TaskRepository taskRepo, UserRepository userRepo, CategoryRepository categoryRepo) {
        this.taskRepo = taskRepo;
        this.userRepo = userRepo;
        this.categoryRepo = categoryRepo;
    }

    public Task createTask(Long userId, Long categoryId, Task task) {
        User user = userRepo.findById(userId).orElseThrow();
        Category category = categoryRepo.findById(categoryId).orElseThrow();

        task.setUser(user);
        task.setCategory(category);

        return taskRepo.save(task);
    }

    public List<Task> getTasksByUser(Long userId) {
        return taskRepo.findByUserId(userId);
    }

    public List<Task> getCompletedTasks(boolean status) {
        return taskRepo.findByCompleted(status);
    }
}
