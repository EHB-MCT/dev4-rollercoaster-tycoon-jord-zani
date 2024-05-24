package be.ehb.rollercoastertycoon.controller

import be.ehb.rollercoastertycoon.model.*
import be.ehb.rollercoastertycoon.service.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/maintenance")
class MaintenanceController(private val maintenanceService: MaintenanceService) {
    @GetMapping
    fun findAll(): List<Maintenance> = maintenanceService.findAll()

    @PostMapping
    fun save(@RequestBody maintenance: Maintenance): Maintenance = maintenanceService.save(maintenance)
}