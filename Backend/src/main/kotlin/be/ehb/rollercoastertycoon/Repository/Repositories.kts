package be.ehb.rollercoastertycoon.repository

import be.ehb.rollercoastertycoon.model.*
import org.springframework.data.jpa.repository.JpaRepository

interface AttractionRepository : JpaRepository<Attraction, Long>
interface CategoryRepository : JpaRepository<Category, Long>
interface FaultRepository : JpaRepository<Fault, Long>
interface MaintenanceRepository : JpaRepository<Maintenance, Long>
