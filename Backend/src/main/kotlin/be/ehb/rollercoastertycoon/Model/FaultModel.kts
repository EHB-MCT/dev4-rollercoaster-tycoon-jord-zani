package be.ehb.rollercoastertycoon.model

import java.util.*
import javax.persistence.*

@Entity
data class Fault(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val description: String,
    val resolved: Boolean,
    @ManyToOne val attraction: Attraction
)