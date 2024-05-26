package be.ehb.rollercoastertycoon.model

import jakarta.persistence.*

@Entity
@Table(name = "faults")
data class Fault(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne @JoinColumn(name = "attraction_id")
    val attraction: Attraction,

    val description: String,
    val resolved: Boolean = false
)