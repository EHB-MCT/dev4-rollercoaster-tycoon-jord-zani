package be.ehb.rollercoastertycoon.service

import be.ehb.rollercoastertycoon.model.Attraction
import be.ehb.rollercoastertycoon.repository.AttractionRepository
import be.ehb.rollercoastertycoon.repository.CategoryRepository
import be.ehb.rollercoastertycoon.repository.FaultRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AttractionService(
    @Autowired private val attractionRepository: AttractionRepository,
    @Autowired private val categoryRepository: CategoryRepository,
    private val faultRepository: FaultRepository
) {

    fun getAllAttractions(): List<Attraction> {
        val attractions = attractionRepository.findAll()
        attractions.forEach { attraction ->
            attraction.hasUnresolvedFaults = faultRepository.findByAttractionId(attraction.id).any { !it.resolved }
        }
        return attractions
    }

    fun getAttractionById(id: Long): Optional<Attraction> {
        return attractionRepository.findById(id).map { attraction ->
            attraction.hasUnresolvedFaults = faultRepository.findByAttractionId(attraction.id).any { !it.resolved }
            attraction
        }
    }

    fun createAttraction(attraction: Attraction): Attraction {
        val category = categoryRepository.findById(attraction.category.id)
            .orElseThrow { IllegalArgumentException("Category not found with id ${attraction.category.id}") }
        return attractionRepository.save(attraction.copy(category = category))
    }

    fun updateAttraction(id: Long, updatedAttraction: Attraction): Optional<Attraction> {
        return attractionRepository.findById(id).map {
            val category = categoryRepository.findById(updatedAttraction.category.id)
                .orElseThrow { IllegalArgumentException("Category not found with id ${updatedAttraction.category.id}") }
            val updated = it.copy(
                name = updatedAttraction.name,
                category = category,
                capacity = updatedAttraction.capacity,
                yearBuilt = updatedAttraction.yearBuilt,
                imageUrl = updatedAttraction.imageUrl,
                videoUrl = updatedAttraction.videoUrl
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
