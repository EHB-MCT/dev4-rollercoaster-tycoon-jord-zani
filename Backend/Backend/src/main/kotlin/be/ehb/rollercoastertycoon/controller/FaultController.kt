package be.ehb.rollercoastertycoon.controller

import be.ehb.rollercoastertycoon.exception.ResourceNotFoundException
import be.ehb.rollercoastertycoon.model.Fault
import be.ehb.rollercoastertycoon.service.FaultService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/faults")
class FaultController(@Autowired private val faultService: FaultService) {

    @GetMapping
    fun getAllFaults(): List<Fault> {
        return faultService.getAllFaults()
    }

    @GetMapping("/attraction/{attractionId}")
    fun getFaultsByAttraction(@PathVariable attractionId: Long): List<Fault> {
        return faultService.getFaultsByAttraction(attractionId)
    }

    @GetMapping("/{id}")
    fun getFaultById(@PathVariable id: Long): ResponseEntity<Fault> {
        return faultService.getFaultById(id).map {
            ResponseEntity.ok(it)
        }.orElseThrow { ResourceNotFoundException("Fault not found with id $id") }
    }

    @PostMapping
    fun createFault(@RequestBody fault: Fault): Fault {
        return faultService.createFault(fault)
    }

    @PutMapping("/{id}/resolve")
    fun resolveFault(@PathVariable id: Long): ResponseEntity<Fault> {
        return faultService.resolveFault(id).map {
            ResponseEntity.ok(it)
        }.orElseThrow { ResourceNotFoundException("Fault not found with id $id") }
    }

    @DeleteMapping("/{id}")
    fun deleteFault(@PathVariable id: Long): ResponseEntity<Void> {
        return if (faultService.deleteFault(id)) {
            ResponseEntity.noContent().build()
        } else {
            throw ResourceNotFoundException("Fault not found with id $id")
        }
    }
}
