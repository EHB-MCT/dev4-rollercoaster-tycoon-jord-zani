package com.example.rollercoaster.service

import com.example.rollercoaster.model.Maintenance
import com.example.rollercoaster.repository.MaintenanceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class MaintenanceService(@Autowired private val maintenanceRepository: MaintenanceRepository) {

    fun getAllMaintenanceRecords(): List<Maintenance> {
        return maintenanceRepository.findAll()
    }

    fun getMaintenanceRecordById(id: Long): Optional<Maintenance> {
        return maintenanceRepository.findById(id)
    }

    fun createMaintenanceRecord(maintenance: Maintenance): Maintenance {
        return maintenanceRepository.save(maintenance)
    }

    fun deleteMaintenanceRecord(id: Long): Boolean {
        return if (maintenanceRepository.existsById(id)) {
            maintenanceRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
