package be.ehb.rollercoastertycoon.service

import be.ehb.rollercoastertycoon.model.*
import be.ehb.rollercoastertycoon.repository.*
import org.springframework.stereotype.Service

@Service
class MaintenanceService(private val maintenanceRepository: MaintenanceRepository) {
    fun findAll(): List<Maintenance> = maintenanceRepository.findAll()
    fun save(maintenance: Maintenance): Maintenance = maintenanceRepository.save(maintenance)
}