package com.amusementpark.model

import java.time.LocalDate
import javax.persistence.*

@Entity
data class Fault(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val description: String,
    val resolved: Boolean = false,
    @ManyToOne @JoinColumn(name = "attraction_id")
    val attraction: Attraction
)