package be.ehb.rollercoastertycoon.service

import be.ehb.rollercoastertycoon.model.Fault
import be.ehb.rollercoastertycoon.repository.FaultRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FaultService(@Autowired private val faultRepository: FaultRepository) {

    fun getAllFaults(): List<Fault> {
        return faultRepository.findAll()
    }

    fun getFaultById(id: Long): Fault {
        return faultRepository.findById(id).orElseThrow { IllegalArgumentException("Fault not found with id $id") }
    }

    fun createFault(fault: Fault): Fault {
        return faultRepository.save(fault)
    }

    fun updateFault(id: Long, updatedFault: Fault): Fault {
        return faultRepository.findById(id).map {
            val updated = it.copy(
                date = updatedFault.date,
                description = updatedFault.description,
                resolved = updatedFault.resolved
            )
            faultRepository.save(updated)
        }.orElseThrow { IllegalArgumentException("Fault not found with id $id") }
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
