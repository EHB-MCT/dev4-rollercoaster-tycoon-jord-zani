package be.ehb.rollercoastertycoon.model

import jakarta.persistence.*

@Entity
@Table(name = "faults")
data class Fault(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val description: String,
    val resolved: Boolean = false
)
