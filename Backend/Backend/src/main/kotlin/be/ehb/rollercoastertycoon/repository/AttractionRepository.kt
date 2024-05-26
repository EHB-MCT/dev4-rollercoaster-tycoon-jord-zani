package be.ehb.rollercoastertycoon.repository

import be.ehb.rollercoastertycoon.model.Attraction
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AttractionRepository : JpaRepository<Attraction, Long> {
    override fun findAll(pageable: Pageable): Page<Attraction>
}
