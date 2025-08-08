package com.example.nutridata.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.nutridata.category.dto.CategoryRequest;
import com.example.nutridata.category.dto.CategoryResponse;

public interface CategoryService {

  Page<CategoryResponse> getAllCategories(Pageable pageable);

  CategoryResponse getCategoryById(Long id);

  CategoryResponse createCategory(CategoryRequest categoryRequest);

  CategoryResponse updateCategoryById(Long id, CategoryRequest categoryRequest);

  void deleteCategoryById(Long id);

}
