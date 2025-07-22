package com.projectimperium.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectimperium.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

    
}
