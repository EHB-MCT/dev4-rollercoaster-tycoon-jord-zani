package be.ehb.rollercoastertycoon.service

import be.ehb.rollercoastertycoon.model.Attraction
import be.ehb.rollercoastertycoon.repository.AttractionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

@Service
class AttractionService(@Autowired private val attractionRepository: AttractionRepository) {

    fun getAllAttractions(pageable: Pageable): Page<Attraction> {
        return attractionRepository.findAll(pageable)
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
