package com.projectimperium.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectimperium.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
// Cria o CRUD da Category, passando um Long como ID
}
