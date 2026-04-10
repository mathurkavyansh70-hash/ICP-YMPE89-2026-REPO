package com.example.DataJpaAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DataJpaAPI.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
