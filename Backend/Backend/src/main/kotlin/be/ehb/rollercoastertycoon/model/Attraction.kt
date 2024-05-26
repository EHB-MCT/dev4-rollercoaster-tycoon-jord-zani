package be.ehb.rollercoastertycoon.model

import jakarta.persistence.*

@Entity
@Table(name = "attractions")
data class Attraction(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val category: String,
    val capacity: Int,
    val yearBuilt: Int,
    val imageUrl: String? = null,
    val videoUrl: String? = null
)
