package be.ehb.rollercoastertycoon.service

import be.ehb.rollercoastertycoon.model.Fault
import be.ehb.rollercoastertycoon.repository.AttractionRepository
import be.ehb.rollercoastertycoon.repository.FaultRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class FaultService(@Autowired private val faultRepository: FaultRepository,
                   @Autowired private val attractionRepository: AttractionRepository) {

    fun getAllFaults(): List<Fault> {
        return faultRepository.findAll()
    }

    fun getFaultsByAttraction(attractionId: Long): List<Fault> {
        val attraction = attractionRepository.findById(attractionId).orElseThrow {
            IllegalArgumentException("Attraction not found with id $attractionId")
        }
        return faultRepository.findByAttraction(attraction)
    }

    fun getFaultById(id: Long): Optional<Fault> {
        return faultRepository.findById(id)
    }

    fun createFault(fault: Fault): Fault {
        return faultRepository.save(fault)
    }

    fun resolveFault(id: Long): Optional<Fault> {
        return faultRepository.findById(id).map {
            val resolved = it.copy(resolved = true)
            faultRepository.save(resolved)
        }
    }

    fun deleteFault(id: Long): Boolean {
        return if (faultRepository.existsById(id)) {
            faultRepository.deleteById(id)
            true
        } else {
            false
        }
    }
}
