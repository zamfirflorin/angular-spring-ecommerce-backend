package com.rawdebun.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rawdebun.ecommerce.dao.ProductRepository;
import com.rawdebun.ecommerce.entity.Product;

@Service
public class ProductService {


	     @Autowired
	     ProductRepository productRepository;
	 
	     public List<Product> getAllProducts() {
	         return this.productRepository.findAll();
	     }
	 

	 
	     //other methods omitted for brevity
	 
	
	
}
