package com.projectimperium.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity // Anotação para mapear as entidades no Spring
@Table(name = "tb_category") // Cria a tabela no banco de dados com esse nome
public class Category implements Serializable{
    
    @Id // Identifica que esse é o ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id é definido para ser autoincrementado
    private Long id;
    private String name;

    @JsonIgnore // Impede que seja passado os produtos que estão cadastrados em uma categoria
    @ManyToMany(mappedBy = "categories") // Relação muitos para muitos, mapeada pelo atributo "categories" na classe products
    private Set<Product> products = new HashSet<>();

    public Category(){
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Category other = (Category) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
