package com.nimapinfotech.app.CRUDOPS.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

//    @PostMapping
//    public ResponseEntity<Category> saveCategory(@RequestBody CategoryDto categoryDto)
//    {
//    	CategoryDto categorCreated = categoryService.createCategory(categoryDto);
//    	
//		return new ResponseEntity<Category>(HttpStatus.CREATED);
//        
//    }

	@PostMapping
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		Category createdCategory = categoryService.createCategory(category);
		return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Category>> getAllCategories(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "3") int size) 
	{
		Pageable paging = PageRequest.of(page, size);
		Page<Category> categories = categoryService.getAllCategories(paging);
		return new ResponseEntity<>(categories.getContent(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
		Category category = categoryService.getCategoryById(id);
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
		Category updatedCategory = categoryService.updateCategory(id, category);
		return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
		categoryService.deleteCategory(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
