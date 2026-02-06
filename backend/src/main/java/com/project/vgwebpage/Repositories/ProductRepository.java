package com.project.vgwebpage.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.vgwebpage.Entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
    
}
