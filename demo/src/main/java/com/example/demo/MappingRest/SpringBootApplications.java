package com.example.demo.MappingRest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.MappingRest.Controller.ProductsController;
import com.example.demo.MappingRest.Entities.Category;
import com.example.demo.MappingRest.Entities.Products;
import com.example.demo.MappingRest.Repository.CategoryRepo;
import com.example.demo.MappingRest.Repository.ProductsRepo;

@SpringBootApplication
public class SpringBootApplications implements CommandLineRunner {
     @Autowired
	ProductsRepo productRepo;
	@Autowired
	CategoryRepo categoryRepo;
	// @Autowired
	// ProductsController productController;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplications.class, args);

	}

	
	@Override
	public void run(String... args) throws Exception {
	System.out.println("Success");

   

	List<Products> products = new ArrayList<>();

	// Category c1 = new Category("5gb ram", products);


	// Product p1 = new Product("Samsung",2,20000L,c1);
	// categoryRepo.save(c1);
	// productRepo.save(p1);

	Category[] categories = {
		new Category(0, "64gb ram",products),
		new Category(0, "12gb ram",products),
		new Category(0, "128gb ram",products)
	 };

	Products[] product ={
		new Products(0, "Samsung",2,20000L,categories[0]),
		new Products(0, "Apple",2,60000L,categories[1]),
		new Products(0, "Tab",3,30000L,categories[2]),
		//new Products(0, "Laptop",4,290776L,categories[3])

	};
	categoryRepo.saveAll(Arrays.asList(categories));
	productRepo.saveAll(Arrays.asList(product));


 }

}