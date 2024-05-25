package com.example.rollercoaster.service

import com.example.rollercoaster.model.Category
import com.example.rollercoaster.repository.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryService(@Autowired private val categoryRepository: CategoryRepository) {

    fun getAllCategories(): List<Category> {
        return categoryRepository.findAll()
    }

    fun getCategoryById(id: Long): Optional<Category> {
        return categoryRepository.findById(id)
    }

    fun createCategory(category: Category): Category {
        return categoryRepository.save(category)
    }

    fun updateCategory(id: Long, updatedCategory: Category): Optional<Category> {
        return categoryRepository.findById(id).map {
            val updated = it.copy(
                name = updatedCategory.name
            )
            categoryRepository.save(updated)
        }
    }

    fun deleteCategory(id: Long): Boolean {
        return if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
