package be.ehb.rollercoastertycoon.service

import be.ehb.rollercoastertycoon.model.*
import be.ehb.rollercoastertycoon.repository.*
import org.springframework.stereotype.Service

@Service
class FaultService(private val faultRepository: FaultRepository) {
    fun findAll(): List<Fault> = faultRepository.findAll()
    fun save(fault: Fault): Fault = faultRepository.save(fault)
}