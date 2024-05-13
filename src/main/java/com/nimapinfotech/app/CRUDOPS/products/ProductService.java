package com.nimapinfotech.app.CRUDOPS.products;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimapinfotech.app.CRUDOPS.category.Category;
import com.nimapinfotech.app.CRUDOPS.category.CategoryRepo;

@Service
public class ProductService 
{
	@Autowired
    private ProductRepo productRepository;
	
	@Autowired CategoryRepo categoryRepo;

	 public Page<Product> getAllProducts(Pageable pageable) 
	 {
	        return productRepository.findAll(pageable);
	    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) 
    {
    	
    	Category category = categoryRepo.findById(product.getCategory().getId())
    			.orElseThrow(() -> new IllegalArgumentException("Category not found"));
    	
    	product.setCategory(category);
    	
    	return productRepository.save(product);
    			
    }
        

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
