package com.rawdebun.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rawdebun.ecommerce.entity.Product;
import com.rawdebun.ecommerce.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {


	    @Autowired
	    private ProductService productService;
	    
	    //create get all bicycles
	    @GetMapping("/products")
	    @ResponseBody
	    public List<Product> getAllProducts()
	    {
	        return productService.getAllProducts();
	    }   

}
	

