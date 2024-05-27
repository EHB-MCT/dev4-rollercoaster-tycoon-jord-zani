package be.ehb.rollercoastertycoon.model

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name = "attractions")
data class Attraction(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    @ManyToOne @JoinColumn(name = "category_id")
    @JsonBackReference
    val category: Category,

    val capacity: Int,

    val yearBuilt: Int,

    val imageUrl: String? = null,

    val videoUrl: String? = null,

    @Transient
    var hasUnresolvedFaults: Boolean = false
)
