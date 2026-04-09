package com.example.TaskAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TaskAPI.Entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
