package com.projectimperium.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectimperium.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
