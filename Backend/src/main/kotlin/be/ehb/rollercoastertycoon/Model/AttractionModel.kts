package be.ehb.rollercoastertycoon.model

import java.util.*
import javax.persistence.*

@Entity
Table(name = "attractions")
data class Attraction(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val category: String,
    val capacity: Int,
    val imageURL: String,
    val onRideVideoURL: String?,
    val buildYear: Int,
    val description: String,
    val heightRequirement: String
)