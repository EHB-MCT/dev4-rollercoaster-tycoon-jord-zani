package be.ehb.rollercoastertycoon.service

import be.ehb.rollercoastertycoon.model.*
import be.ehb.rollercoastertycoon.repository.*
import org.springframework.stereotype.Service

@Service
class CategoryService(private val categoryRepository: CategoryRepository) {
    fun findAll(): List<Category> = categoryRepository.findAll()
    fun save(category: Category): Category = categoryRepository.save(category)
    fun deleteById(id: Long) = categoryRepository.deleteById(id)
}