package com.springboot.firstproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.firstproject.Entity.Department;

/**
 * This is the repository layer that extends the JpaRepository interface,
 * providing CRUD operations for the Department entity.
 * 
 * @author Shawn D. Crawford
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /**
     * This method is used to find a department by its name.Ignoring case
     * 
     * @param name the name of the department to find
     * @return the department with the given name, or null if none is found
     */
    Department findByDepartmentNameIgnoreCase(String name);

}
