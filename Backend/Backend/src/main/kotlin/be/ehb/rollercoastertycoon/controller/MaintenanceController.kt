package be.ehb.rollercoastertycoon.controller

import be.ehb.rollercoastertycoon.exception.ResourceNotFoundException
import be.ehb.rollercoastertycoon.model.Maintenance
import be.ehb.rollercoastertycoon.service.MaintenanceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/maintenance")
class MaintenanceController(@Autowired private val maintenanceService: MaintenanceService) {

    @GetMapping
    fun getAllMaintenanceRecords(): List<Maintenance> {
        return maintenanceService.getAllMaintenanceRecords()
    }

    @GetMapping("/attraction/{attractionId}")
    fun getMaintenanceRecordsByAttraction(@PathVariable attractionId: Long): List<Maintenance> {
        return maintenanceService.getMaintenanceRecordsByAttraction(attractionId)
    }

    @GetMapping("/{id}")
    fun getMaintenanceRecordById(@PathVariable id: Long): ResponseEntity<Maintenance> {
        return maintenanceService.getMaintenanceRecordById(id).map {
            ResponseEntity.ok(it)
        }.orElseThrow { ResourceNotFoundException("Maintenance record not found with id $id") }
    }

    @PostMapping
    fun createMaintenanceRecord(@RequestBody maintenance: Maintenance): Maintenance {
        return maintenanceService.createMaintenanceRecord(maintenance)
    }

    @PutMapping("/{id}")
    fun updateMaintenanceRecord(@PathVariable id: Long, @RequestBody maintenance: Maintenance): ResponseEntity<Maintenance> {
        return maintenanceService.updateMaintenanceRecord(id, maintenance).map {
            ResponseEntity.ok(it)
        }.orElseThrow { ResourceNotFoundException("Maintenance record not found with id $id") }
    }

    @DeleteMapping("/{id}")
    fun deleteMaintenanceRecord(@PathVariable id: Long): ResponseEntity<Void> {
        return if (maintenanceService.deleteMaintenanceRecord(id)) {
            ResponseEntity.noContent().build()
        } else {
            throw ResourceNotFoundException("Maintenance record not found with id $id")
        }
    }
}
