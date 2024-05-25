package com.example.rollercoaster.service

import com.example.rollercoaster.model.Fault
import com.example.rollercoaster.repository.FaultRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class FaultService(@Autowired private val faultRepository: FaultRepository) {

    fun getAllFaults(): List<Fault> {
        return faultRepository.findAll()
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
