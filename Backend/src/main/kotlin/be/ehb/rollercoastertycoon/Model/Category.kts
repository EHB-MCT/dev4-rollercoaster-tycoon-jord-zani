package com.amusementpark.model

import java.time.LocalDate
import javax.persistence.*

@Entity
data class Category(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String
)