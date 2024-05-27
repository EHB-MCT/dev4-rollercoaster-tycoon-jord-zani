package be.ehb.rollercoastertycoon.model

import jakarta.persistence.*

@Entity
@Table(name = "maintenance_records")
data class MaintenanceRecord(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "attraction_id")
    var attractionId: Long = 0,

    val date: String,
    val description: String,
    val resolved: Boolean = false
)
