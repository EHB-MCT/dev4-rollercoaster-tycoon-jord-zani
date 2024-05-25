package be.ehb.rollercoastertycoon.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "maintenance")
data class Maintenance(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val date: Date,
    val comments: String,
    val description: String,
    @ManyToOne @JoinColumn(name = "attraction_id")
    val attraction: Attraction
)