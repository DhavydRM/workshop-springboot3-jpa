package com.projectimperium.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectimperium.course.entities.Product;
import com.projectimperium.course.services.ProductServices;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
    
    @Autowired
    private ProductServices service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) { // Pego o ID passado e tranforma em um variavel
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
