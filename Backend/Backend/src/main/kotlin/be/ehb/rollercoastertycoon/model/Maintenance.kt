package be.ehb.rollercoastertycoon.model

import jakarta.persistence.*

@Entity
@Table(name = "maintenance")
data class Maintenance(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val date: String,
    val description: String,
    @ManyToOne @JoinColumn(name = "attraction_id")
    val attraction: Attraction
)