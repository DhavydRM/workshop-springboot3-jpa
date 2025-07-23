package com.projectimperium.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectimperium.course.entities.OrderItem;
import com.projectimperium.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{

}
