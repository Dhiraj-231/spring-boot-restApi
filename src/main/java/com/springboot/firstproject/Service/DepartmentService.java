package com.springboot.firstproject.Service;

import java.util.List;

import com.springboot.firstproject.Entity.Department;
import com.springboot.firstproject.error.DepartmentNotFoundException;

public interface DepartmentService {

    /**
     * This method is used to save a department to the database.
     *
     * @param department the department to be saved
     * @return the saved department
     */
    Department saveDepartment(Department department);

    /**
     * This method is used to get all the departments from the database.
     *
     * @return a list of all departments
     */
    List<Department> getAllDepartments();

    /**
     * This method is used to get a department from the database based on its id.
     *
     * @param id the id of the department to retrieve
     * @return the department with the given id, null if not found
     * @throws DepartmentNotFoundException 
     */
    Department getDepartmentById(Long id) throws DepartmentNotFoundException;

    /**
     * Deletes a department from the database based on its id.
     *
     * @param id the id of the department to delete
     */
    void deleteDepartmentById(Long id);

    /**
     * Updates a department in the database with the given id.
     *
     * @param id the id of the department to update
     * @param department the updated department data
     * @return the updated department
     */
    Department updateDepartment(Long id, Department department);


    /**
     * Retrieves a department from the database based on its name.
     *
     * @param name the name of the department to retrieve
     * @return the department with the given name, null if not found
     */
    Department getDepartmentByName(String name);


}
