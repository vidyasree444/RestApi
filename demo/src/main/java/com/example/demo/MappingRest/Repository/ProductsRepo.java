package com.example.demo.MappingRest.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.MappingRest.Entities.Category;
import com.example.demo.MappingRest.Entities.Products;

@Repository
public interface ProductsRepo extends JpaRepository<Products,Integer>{

     Products findByProdName(String prodName);
     List<Products> findAllByCategory(Category category);
     List<Products> findByPriceBetween(Long min,Long max);
     List<Products> findTop5ByOrderByPriceDesc();
}
