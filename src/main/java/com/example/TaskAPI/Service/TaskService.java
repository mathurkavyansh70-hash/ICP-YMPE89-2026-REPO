package com.example.TaskAPI.Service;

import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.springframework.stereotype.Service;

import com.example.TaskAPI.Entity.Task;
import com.example.TaskAPI.Exception.ResourceNotFoundException;
import com.example.TaskAPI.Repository.TaskRepository;

import jakarta.annotation.Resource;

@Service
public class TaskService {
    private final TaskRepository repo;
    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }   
    public Task createTask(Task task) {
        return repo.save(task);
    }
    public List<Task> getAllTasks() {
        return repo.findAll();
    }
    public Task getTaskById(Long id) {
        return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Task not found with id: "));
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task task = getTaskById(id);
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.isCompleted());
        return repo.save(task);
    }

    public void deleteTask(Long id) {
        repo.deleteById(id);
    }
}
