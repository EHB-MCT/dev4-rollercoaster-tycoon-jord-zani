package com.example.rollercoaster.service

import com.example.rollercoaster.model.Attraction
import com.example.rollercoaster.repository.AttractionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AttractionService(@Autowired private val attractionRepository: AttractionRepository) {

    fun getAllAttractions(): List<Attraction> {
        return attractionRepository.findAll()
    }

    fun getAttractionById(id: Long): Optional<Attraction> {
        return attractionRepository.findById(id)
    }

    fun createAttraction(attraction: Attraction): Attraction {
        return attractionRepository.save(attraction)
    }

    fun updateAttraction(id: Long, updatedAttraction: Attraction): Optional<Attraction> {
        return attractionRepository.findById(id).map {
            val updated = it.copy(
                name = updatedAttraction.name,
                category = updatedAttraction.category,
                capacity = updatedAttraction.capacity,
                buildYear = updatedAttraction.buildYear,
                imageUrl = updatedAttraction.imageUrl,
                onRideVideoURL = updatedAttraction.onRideVideoURL,
                description = updatedAttraction.description,
                heightRequirement = updatedAttraction.heightRequirement
            )
            attractionRepository.save(updated)
        }
    }

    fun deleteAttraction(id: Long): Boolean {
        return if (attractionRepository.existsById(id)) {
            attractionRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
