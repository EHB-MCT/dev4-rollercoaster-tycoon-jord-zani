package be.ehb.rollercoastertycoon.controller

import be.ehb.rollercoastertycoon.exception.ResourceNotFoundException
import be.ehb.rollercoastertycoon.model.MaintenanceRecord
import be.ehb.rollercoastertycoon.service.MaintenanceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/attractions/{attractionId}/maintenance")
@CrossOrigin(origins = ["http://localhost:5173"])
class MaintenanceController(@Autowired private val maintenanceService: MaintenanceService) {

    @GetMapping
    fun getAllMaintenanceRecords(@PathVariable attractionId: Long): List<MaintenanceRecord> {
        return maintenanceService.getAllMaintenanceRecords(attractionId)
    }

    @PostMapping
    fun createMaintenanceRecord(@PathVariable attractionId: Long, @RequestBody maintenanceRecord: MaintenanceRecord): MaintenanceRecord {
        maintenanceRecord.attractionId = attractionId
        return maintenanceService.createMaintenanceRecord(maintenanceRecord)
    }

    @PutMapping("/{id}/resolve")
    fun resolveMaintenanceRecord(@PathVariable id: Long): ResponseEntity<MaintenanceRecord> {
        return maintenanceService.resolveMaintenanceRecord(id).map {
            ResponseEntity.ok(it)
        }.orElseThrow { ResourceNotFoundException("Maintenance record not found with id $id") }
    }
}
