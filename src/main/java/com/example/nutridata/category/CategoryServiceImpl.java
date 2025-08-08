package com.example.nutridata.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.nutridata.category.dto.CategoryRequest;
import com.example.nutridata.category.dto.CategoryResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;

  @Override
  public Page<CategoryResponse> getAllCategories(Pageable pageable) {
    return categoryRepository.findAll(pageable)
        .map(this::mapToResponse);
  }

  @Override
  public CategoryResponse getCategoryById(Long id) {
    return categoryRepository.findById(id)
        .map(this::mapToResponse)
        .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
  }

  @Override
  public CategoryResponse createCategory(CategoryRequest categoryRequest) {
    Category category = new Category();

    category.setName(categoryRequest.name());
    category.setDescription(categoryRequest.description());

    return mapToResponse(categoryRepository.save(category));
  }

  @Override
  public CategoryResponse updateCategoryById(Long id, CategoryRequest categoryRequest) {
    Category foundCategory = categoryRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

    foundCategory.setName(categoryRequest.name());
    foundCategory.setDescription(categoryRequest.description());

    return mapToResponse(categoryRepository.save(foundCategory));
  }

  @Override
  public void deleteCategoryById(Long id) {
    categoryRepository.deleteById(id);
  }

  private CategoryResponse mapToResponse(Category category) {
    return new CategoryResponse(
        category.getId(),
        category.getName(),
        category.getDescription());
  }

}
