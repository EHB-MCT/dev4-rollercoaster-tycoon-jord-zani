package com.amusementpark.repository

import com.amusementpark.model.*
import org.springframework.data.jpa.repository.JpaRepository

interface AttractionRepository : JpaRepository<Attraction, Long>
interface CategoryRepository : JpaRepository<Category, Long>
interface MaintenanceRepository : JpaRepository<Maintenance, Long>
interface FaultRepository : JpaRepository<Fault, Long>
