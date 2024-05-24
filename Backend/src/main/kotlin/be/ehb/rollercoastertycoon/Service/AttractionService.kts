package be.ehb.rollercoastertycoon.service

import be.ehb.rollercoastertycoon.model.*
import be.ehb.rollercoastertycoon.repository.*
import org.springframework.stereotype.Service

@Service
class AttractionService(private val attractionRepository: AttractionRepository) {
    fun findAll(): List<Attraction> = attractionRepository.findAll()
    fun save(attraction: Attraction): Attraction = attractionRepository.save(attraction)
    fun deleteById(id: Long) = attractionRepository.deleteById(id)
}