package com.example.rollercoaster.controller

import com.example.rollercoaster.model.Maintenance
import com.example.rollercoaster.service.MaintenanceService
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

    @GetMapping("/{id}")
    fun getMaintenanceRecordById(@PathVariable id: Long): ResponseEntity<Maintenance> {
        return maintenanceService.getMaintenanceRecordById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping
    fun createMaintenanceRecord(@RequestBody maintenance: Maintenance): Maintenance {
        return maintenanceService.createMaintenanceRecord(maintenance)
    }

    @DeleteMapping("/{id}")
    fun deleteMaintenanceRecord(@PathVariable id: Long): ResponseEntity<Void> {
        return if (maintenanceService.deleteMaintenanceRecord(id)) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
