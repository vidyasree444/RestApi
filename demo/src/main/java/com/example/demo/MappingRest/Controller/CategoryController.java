package com.example.demo.MappingRest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MappingRest.Repository.CategoryRepo;

@RestController
public class CategoryController {
    
    @Autowired
    CategoryRepo categoryRepo;
}
