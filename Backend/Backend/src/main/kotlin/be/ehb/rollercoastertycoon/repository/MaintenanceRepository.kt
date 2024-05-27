package be.ehb.rollercoastertycoon.repository

import be.ehb.rollercoastertycoon.model.MaintenanceRecord
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MaintenanceRepository : JpaRepository<MaintenanceRecord, Long> {
    fun findByAttractionId(attractionId: Long): List<MaintenanceRecord>
}
