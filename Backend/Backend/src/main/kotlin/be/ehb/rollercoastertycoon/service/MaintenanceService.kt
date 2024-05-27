package be.ehb.rollercoastertycoon.service

import be.ehb.rollercoastertycoon.model.MaintenanceRecord
import be.ehb.rollercoastertycoon.repository.MaintenanceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class MaintenanceService(@Autowired private val maintenanceRepository: MaintenanceRepository) {

    fun getAllMaintenanceRecords(attractionId: Long): List<MaintenanceRecord> {
        return maintenanceRepository.findByAttractionId(attractionId)
    }

    fun createMaintenanceRecord(maintenanceRecord: MaintenanceRecord): MaintenanceRecord {
        return maintenanceRepository.save(maintenanceRecord)
    }

    fun resolveMaintenanceRecord(id: Long): Optional<MaintenanceRecord> {
        val record = maintenanceRepository.findById(id)
        if (record.isPresent) {
            val resolvedRecord = record.get().copy(resolved = true)
            maintenanceRepository.save(resolvedRecord)
            return Optional.of(resolvedRecord)
        }
        return Optional.empty()
    }
}
