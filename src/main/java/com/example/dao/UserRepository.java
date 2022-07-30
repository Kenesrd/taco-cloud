package com.example.dao;

import com.example.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername (String username);
    String findByEmail(String email);
    String findByPhoneNumber(String phoneNumber);
}
