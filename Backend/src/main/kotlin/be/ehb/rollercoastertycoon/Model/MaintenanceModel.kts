package be.ehb.rollercoastertycoon.model

import java.util.*
import javax.persistence.*

@Entity
data class Maintenance(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val date: Date,
    val comments: String,
    @ManyToOne val attraction: Attraction
)