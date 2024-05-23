package com.amusementpark.model

import java.time.LocalDate
import javax.persistence.*

@Entity
data class Attraction(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val category: String,
    val capacity: Int,
    val buildYear: Int,
    val imageURL: String,
    val onRideVideoURL: String?,
    val description: String,
    val location: String,
    val heightRestriction: String,
    @OneToMany(mappedBy = "attraction", cascade = [CascadeType.ALL], orphanRemoval = true)
    val maintenances: List<Maintenance> = mutableListOf(),
    @OneToMany(mappedBy = "attraction", cascade = [CascadeType.ALL], orphanRemoval = true)
    val faults: List<Fault> = mutableListOf()
)