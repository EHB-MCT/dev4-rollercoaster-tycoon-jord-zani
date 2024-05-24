package be.ehb.rollercoastertycoon.controller

import be.ehb.rollercoastertycoon.model.*
import be.ehb.rollercoastertycoon.service.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/attractions")
class AttractionController(private val attractionService: AttractionService) {
    @GetMapping
    fun findAll(): List<Attraction> = attractionService.findAll()

    @PostMapping
    fun save(@RequestBody attraction: Attraction): Attraction = attractionService.save(attraction)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) = attractionService.deleteById(id)
}