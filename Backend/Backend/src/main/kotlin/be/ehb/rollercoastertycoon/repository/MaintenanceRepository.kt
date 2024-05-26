package be.ehb.rollercoastertycoon.repository

import be.ehb.rollercoastertycoon.model.Maintenance
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MaintenanceRepository : JpaRepository<Maintenance, Long> {
    fun findByAttractionId(attractionId: Long): List<Maintenance>
}
