package com.projectimperium.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectimperium.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
