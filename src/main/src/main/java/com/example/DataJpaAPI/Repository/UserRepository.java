package com.example.DataJpaAPI.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DataJpaAPI.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
