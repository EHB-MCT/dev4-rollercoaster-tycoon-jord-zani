package be.ehb.rollercoastertycoon.controller

import be.ehb.rollercoastertycoon.model.*
import be.ehb.rollercoastertycoon.service.*
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/faults")
class FaultController(private val faultService: FaultService) {
    @GetMapping
    fun findAll(): List<Fault> = faultService.findAll()

    @PostMapping
    fun save(@RequestBody fault: Fault): Fault = faultService.save(fault)
}