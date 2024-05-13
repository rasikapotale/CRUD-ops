package com.nimapinfotech.app.CRUDOPS.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService 
{
	@Autowired
	CategoryRepo categoryRepo;


//	public CategoryDto createCategory(CategoryDto dto) 
//	{
//		Category category = dtoToEntity(dto);
//
//		Category category2 = categoryRepo.save(category);
//
//		return entityToDto(category2);
//
//	}
	
	public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }


	public Page<Category> getAllCategories(Pageable pageable) 
	{
		return categoryRepo.findAll(pageable);
	}

	public Category getCategoryById(Long id)
	{
		return categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
	}

	public Category updateCategory(Long id, Category category) 
	{
		category.setId(id);
		return categoryRepo.save(category);
	}

	public void deleteCategory(Long id)
	{
		categoryRepo.deleteById(id);
	}

	Category dtoToEntity(CategoryDto categoryDto) 
	{
		Category category = new Category();
		category.setName(categoryDto.getName());
		return category;

	}

	CategoryDto entityToDto(Category category) 
	{
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(category.getId());
		categoryDto.setName(category.getName());
		return categoryDto;

	}

	 
}
