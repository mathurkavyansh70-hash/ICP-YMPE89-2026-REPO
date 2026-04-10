package com.example.DataJpaAPI.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DataJpaAPI.Entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>  {
     List<Task> findByUserId(Long userId);

    List<Task> findByCompleted(boolean completed);
}
