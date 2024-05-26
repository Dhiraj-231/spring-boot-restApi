package com.springboot.firstproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.firstproject.Entity.Department;
import com.springboot.firstproject.Service.DepartmentService;
import com.springboot.firstproject.error.DepartmentNotFoundException;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
    /**
     * The service object for managing department operations.
     */
    @Autowired
    private DepartmentService departmentService; // Autowired department service object
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);

    /**
     * Save a department to the database.
     *
     * @param department The department object to be saved.
     * @return The saved department object.
     */
    @PostMapping("/save")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        // Call the saveDepartment method of the departmentService object
        // to save the department and return the saved department object.
        logger.info("Inside save department of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    /**
     * Retrieve all departments from the database.
     *
     * @return A list of Department objects representing all departments.
     */
    @GetMapping("/all")
    public List<Department> getAllDepartments() {
        // Call the getAllDepartments method of the departmentService object
        // to retrieve all departments and return the list.
        return departmentService.getAllDepartments();
    }

    /**
     * Retrieve a department from the database by its ID.
     *
     * @param id The ID of the department to retrieve.
     * @return The Department object representing the department with the given ID.
     * @throws DepartmentNotFoundException
     */
    @GetMapping("/one/{id}")
    public Department getDepartementById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        // Call the getDepartmentById method of the departmentService object
        // to retrieve the department with the given ID and return it.
        logger.info("Inside getDepartmentById of DepartmentController");
        return departmentService.getDepartmentById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartmentById(@PathVariable("id") Long id) {
        // Call the deleteDepartmentById method of the departmentService object
        // to delete the department with the given ID.
        departmentService.deleteDepartmentById(id);
    }

    @PutMapping("/update/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
        // Call the updateDepartment method of the departmentService object
        // to update the department with the given ID and return the updated department.
        return departmentService.updateDepartment(id, department);
    }

    /**
     * Retrieve a department from the database by its name.
     *
     * @param name The name of the department to retrieve.
     * @return The Department object representing the department with the given
     *         name.
     */
    @GetMapping("/search/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name) {
        // Call the getDepartmentByName method of the departmentService object
        // to retrieve the department with the given name and return it.
        return departmentService.getDepartmentByName(name);
    }
}
