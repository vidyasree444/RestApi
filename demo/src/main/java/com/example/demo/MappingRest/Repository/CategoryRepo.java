package com.example.demo.MappingRest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.MappingRest.Entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer>{
    
   
}
