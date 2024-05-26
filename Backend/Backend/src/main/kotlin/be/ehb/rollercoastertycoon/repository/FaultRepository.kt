package be.ehb.rollercoastertycoon.repository

import be.ehb.rollercoastertycoon.model.Attraction
import be.ehb.rollercoastertycoon.model.Fault
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FaultRepository : JpaRepository<Fault, Long> {
    fun findByAttraction(attraction: Attraction): List<Fault>
}
