package com.example.rollercoaster.controller

import com.example.rollercoaster.model.Category
import com.example.rollercoaster.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/categories")
class CategoryController(@Autowired private val categoryService: CategoryService) {

    @GetMapping
    fun getAllCategories(): List<Category> {
        return categoryService.getAllCategories()
    }

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Long): ResponseEntity<Category> {
        return categoryService.getCategoryById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun createCategory(@RequestBody category: Category): Category {
        return categoryService.createCategory(category)
    }

    @PutMapping("/{id}")
    fun updateCategory(@PathVariable id: Long, @RequestBody category: Category): ResponseEntity<Category> {
        return categoryService.updateCategory(id, category).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: Long): ResponseEntity<Void> {
        return if (categoryService.deleteCategory(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
