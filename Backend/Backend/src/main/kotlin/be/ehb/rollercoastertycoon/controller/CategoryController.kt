package be.ehb.rollercoastertycoon.controller

import be.ehb.rollercoastertycoon.exception.ResourceNotFoundException
import be.ehb.rollercoastertycoon.model.Category
import be.ehb.rollercoastertycoon.service.CategoryService
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
        }.orElseThrow { ResourceNotFoundException("Category not found with id $id") }
    }

    @PostMapping
    fun createCategory(@RequestBody category: Category): Category {
        return categoryService.createCategory(category)
    }

    @PutMapping("/{id}")
    fun updateCategory(@PathVariable id: Long, @RequestBody category: Category): ResponseEntity<Category> {
        return categoryService.updateCategory(id, category).map {
            ResponseEntity.ok(it)
        }.orElseThrow { ResourceNotFoundException("Category not found with id $id") }
    }

    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable id: Long): ResponseEntity<Void> {
        return if (categoryService.deleteCategory(id)) {
            ResponseEntity.noContent().build()
        } else {
            throw ResourceNotFoundException("Category not found with id $id")
        }
    }
}
