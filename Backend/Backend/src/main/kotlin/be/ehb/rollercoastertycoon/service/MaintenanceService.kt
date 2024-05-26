package be.ehb.rollercoastertycoon.service

import be.ehb.rollercoastertycoon.model.Maintenance
import be.ehb.rollercoastertycoon.repository.MaintenanceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class MaintenanceService(@Autowired private val maintenanceRepository: MaintenanceRepository) {

    fun getAllMaintenanceRecords(): List<Maintenance> {
        return maintenanceRepository.findAll()
    }

    fun getMaintenanceRecordsByAttraction(attractionId: Long): List<Maintenance> {
        return maintenanceRepository.findByAttractionId(attractionId)
    }

    fun getMaintenanceRecordById(id: Long): Optional<Maintenance> {
        return maintenanceRepository.findById(id)
    }

    fun createMaintenanceRecord(maintenance: Maintenance): Maintenance {
        return maintenanceRepository.save(maintenance)
    }

    fun updateMaintenanceRecord(id: Long, updatedMaintenance: Maintenance): Optional<Maintenance> {
        return maintenanceRepository.findById(id).map {
            val updated = it.copy(
                date = updatedMaintenance.date,
                description = updatedMaintenance.description,
                attraction = updatedMaintenance.attraction
            )
            maintenanceRepository.save(updated)
        }
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
