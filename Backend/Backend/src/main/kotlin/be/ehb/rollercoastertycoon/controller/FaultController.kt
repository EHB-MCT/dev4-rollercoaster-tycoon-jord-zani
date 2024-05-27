package be.ehb.rollercoastertycoon.controller

import be.ehb.rollercoastertycoon.model.Fault
import be.ehb.rollercoastertycoon.service.FaultService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/faults")
@CrossOrigin(origins = ["http://localhost:5173"])
class FaultController(@Autowired private val faultService: FaultService) {

    @GetMapping
    fun getAllFaults(): List<Fault> {
        return faultService.getAllFaults()
    }

    @GetMapping("/{id}")
    fun getFaultById(@PathVariable id: Long): ResponseEntity<Fault> {
        return ResponseEntity.ok(faultService.getFaultById(id))
    }

    @PostMapping
    fun createFault(@RequestBody fault: Fault): ResponseEntity<Fault> {
        return ResponseEntity.ok(faultService.createFault(fault))
    }

    @PutMapping("/{id}")
    fun updateFault(@PathVariable id: Long, @RequestBody fault: Fault): ResponseEntity<Fault> {
        return ResponseEntity.ok(faultService.updateFault(id, fault))
    }

    @DeleteMapping("/{id}")
    fun deleteFault(@PathVariable id: Long): ResponseEntity<Void> {
        return if (faultService.deleteFault(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
