package be.ehb.rollercoastertycoon.controller

import be.ehb.rollercoastertycoon.model.*
import be.ehb.rollercoastertycoon.service.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/categories")
class CategoryController(private val categoryService: CategoryService) {
    @GetMapping
    fun findAll(): List<Category> = categoryService.findAll()

    @PostMapping
    fun save(@RequestBody category: Category): Category = categoryService.save(category)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) = categoryService.deleteById(id)
}