package com.example.demo.MappingRest.Controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MappingRest.Entities.Category;
import com.example.demo.MappingRest.Entities.Products;
import com.example.demo.MappingRest.Repository.CategoryRepo;
import com.example.demo.MappingRest.Repository.ProductsRepo;


@RestController
@RequestMapping("/Products")
public class ProductsController {
    @Autowired
    ProductsRepo productRepo;
    @Autowired
    CategoryRepo categoryRepo;
  
   

    // @GetMapping("/allproducts")
    // public List<ProductDto> getAllProducts(){

    //    List<Product> product= productRepo.findAll();
    //    List<ProductDto> allproducts = new ArrayList<>();
    //    for(Product allproduct:product){
    //     ProductDto productdto = modelMapper.map(allproduct,ProductDto.class);
    //     allproducts.add(productdto);


    // }

   
    @GetMapping("allproducts")
    public List<Products> getAllProducts(){

       List<Products> product= productRepo.findAll();
       return product; 

}
    @PostMapping("/add")
    public void createProduct(@RequestBody Products product){
        // Product p= new Product();
        // p.setProdName(product.getProdName());
        // p.setQty(product.getQty());
        // p.setPrice(product.getPrice());
        productRepo.save(product);

    }

    @PutMapping("/update/{id}")
    public void updateProduct(@PathVariable int id,@RequestBody Products product){
        Products p1 = productRepo.findById(id).get();
    
        if(product.getProdName()!=null){
            p1.setProdName(product.getProdName());
        }
        if(product.getPrice()!=null){
            p1.setPrice(product.getPrice());
        }
        if(product.getQty()!=0){
            p1.setQty(product.getQty());
        }


    productRepo.save(p1);
    }
    @PutMapping("/updateqty/{id}")
    public void updateQty(@PathVariable int id,@RequestBody Products product){

        Products p1 = productRepo.findById(id).get();
        p1.setQty(product.getQty());

        productRepo.save(p1);

    }
 
  

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id){
        Products p1 = productRepo.findById(id).get();
        productRepo.delete(p1);
    }

    @DeleteMapping("/deleteByprodName/{prodName}")
    public void deleteByName(@PathVariable String prodName){
        Products product = productRepo.findByProdName(prodName);

        productRepo.delete(product);

    }
    @GetMapping("/productsByCategory/{id}")
    public List<Products> getAllProductByCategory(@PathVariable ("id") int catCode){

       Category category = categoryRepo.findById(catCode).get();
       
    
       List<Products> productslist = productRepo.findAllByCategory(category);
   
       return productslist;
    
    }
    //http://localhost:8080/Products/range?min=5000&max=20000
    @GetMapping("/range")
    public List<Products> productsBetweenRange(@RequestParam Long min,@RequestParam Long max){
        return productRepo.findByPriceBetween(min, max);
    }
    @GetMapping("/Top")
    public List<Products> topProducts(){
        return productRepo.findTop5ByOrderByPriceDesc();
    }
    
}