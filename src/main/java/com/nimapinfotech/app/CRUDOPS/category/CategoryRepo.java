package com.nimapinfotech.app.CRUDOPS.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends PagingAndSortingRepository<Category, Long> , JpaRepository<Category, Long>
{
	
}
