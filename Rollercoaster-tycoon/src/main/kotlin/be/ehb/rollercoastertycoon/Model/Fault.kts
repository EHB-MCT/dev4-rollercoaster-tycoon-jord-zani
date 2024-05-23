package com.amusementpark.model

import java.time.LocalDate
import javax.persistence.*

@Entity
data class Maintenance(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val date: LocalDate,
    val comments: String,
    @ManyToOne @JoinColumn(name = "attraction_id")
    val attraction: Attraction
)