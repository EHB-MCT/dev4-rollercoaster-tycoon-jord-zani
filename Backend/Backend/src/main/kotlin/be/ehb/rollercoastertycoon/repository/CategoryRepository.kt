package be.ehb.rollercoastertycoon.repository

import be.ehb.rollercoastertycoon.model.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : JpaRepository<Category, Long>
