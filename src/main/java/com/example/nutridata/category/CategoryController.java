package com.example.nutridata.category;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.nutridata.category.dto.CategoryRequest;
import com.example.nutridata.category.dto.CategoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryService categoryService;

  @GetMapping
  public ResponseEntity<Page<CategoryResponse>> getAllCategories(Pageable pageable) {
    Page<CategoryResponse> categories = categoryService.getAllCategories(pageable);

    return ResponseEntity.ok(categories);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
    try {
      CategoryResponse foundCategory = categoryService.getCategoryById(id);

      return ResponseEntity.ok(foundCategory);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category not found with id: " + id);
    }
  }

  @PostMapping
  public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryRequest categoryRequest) {
    try {
      CategoryResponse createdCategory = categoryService.createCategory(categoryRequest);

      return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating category");
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateCategory(
      @PathVariable Long id,
      @Valid @RequestBody CategoryRequest categoryRequest) {
    try {
      CategoryResponse updatedCategory = categoryService.updateCategoryById(id, categoryRequest);

      return ResponseEntity.ok(updatedCategory);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating category");
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Long id) {
    categoryService.deleteCategoryById(id);

    return ResponseEntity.noContent().build();
  }

}
