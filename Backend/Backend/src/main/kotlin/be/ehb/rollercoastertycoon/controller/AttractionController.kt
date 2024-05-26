package be.ehb.rollercoastertycoon.controller

import be.ehb.rollercoastertycoon.exception.ResourceNotFoundException
import be.ehb.rollercoastertycoon.model.Attraction
import be.ehb.rollercoastertycoon.service.AttractionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/attractions")
@CrossOrigin(origins = ["http://localhost:5173"])
class AttractionController(@Autowired private val attractionService: AttractionService) {

    @GetMapping
    fun getAllAttractions(): List<Attraction> {
        return attractionService.getAllAttractions()
    }

    @GetMapping("/{id}")
    fun getAttractionById(@PathVariable id: Long): ResponseEntity<Attraction> {
        return attractionService.getAttractionById(id).map {
            ResponseEntity.ok(it)
        }.orElseThrow { ResourceNotFoundException("Attraction not found with id $id") }
    }

    @PostMapping
    fun createAttraction(@RequestBody attraction: Attraction): Attraction {
        println("Received attraction: $attraction")
        return attractionService.createAttraction(attraction)
    }

    @PutMapping("/{id}")
    fun updateAttraction(@PathVariable id: Long, @RequestBody attraction: Attraction): ResponseEntity<Attraction> {
        return attractionService.updateAttraction(id, attraction).map {
            ResponseEntity.ok(it)
        }.orElseThrow { ResourceNotFoundException("Attraction not found with id $id") }
    }

    @DeleteMapping("/{id}")
    fun deleteAttraction(@PathVariable id: Long): ResponseEntity<Void> {
        return if (attractionService.deleteAttraction(id)) {
            ResponseEntity.noContent().build()
        } else {
            throw ResourceNotFoundException("Attraction not found with id $id")
        }
    }
}
