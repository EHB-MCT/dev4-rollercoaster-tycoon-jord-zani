package be.ehb.rollercoastertycoon.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(name = "categories")
data class Category(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    val attractions: List<Attraction> = mutableListOf()
)
