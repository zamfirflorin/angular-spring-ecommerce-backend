package com.rawdebun.ecommerce.entity;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="product_category")
// @Data -- known bug
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
public class ProductCategory implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final Logger logger = LoggerFactory.getLogger(ProductCategory.class);
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products;

	public ProductCategory(Long id, String categoryName, Set<Product> products) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.products = products;
	}

	public ProductCategory() {
		
	}
    
    
}








