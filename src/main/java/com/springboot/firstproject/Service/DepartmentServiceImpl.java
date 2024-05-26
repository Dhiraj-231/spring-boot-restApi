package com.springboot.firstproject.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.firstproject.Entity.Department;
import com.springboot.firstproject.Repository.DepartmentRepository;
import com.springboot.firstproject.error.DepartmentNotFoundException;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    /**
     * The repository used to interact with the database for department-related
     * operations.
     */
    @Autowired
    private DepartmentRepository departmentRepository; // Autowire the department repository

    /**
     * Saves the given department to the repository.
     * 
     * @param department The department to be saved.
     * @return The saved department.
     */
    @Override
    public Department saveDepartment(Department department) {
        // Call the save method of the repository to save the department
        return departmentRepository.save(department);
    }

    /**
     * Retrieves all departments from the repository.
     *
     * @return A list of all departments.
     */
    @Override
    public List<Department> getAllDepartments() {
        // Call the findAll method of the repository to retrieve all departments
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);

        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department not found ");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    /**
     * Updates an existing department in the repository.
     *
     * @param id         The ID of the department to be updated.
     * @param department The department object containing the updated values.
     * @return The updated department.
     */
    @Override
    public Department updateDepartment(Long id, Department department) {
        // Retrieve the existing department from the repository
        Department existingDepartment = departmentRepository.findById(id).get();

        // Update the department name if it is not null or empty
        if (Objects.nonNull(department.getDepartmentName())
                && !"".equalsIgnoreCase(department.getDepartmentName())) {
            existingDepartment.setDepartmentName(department.getDepartmentName());
        }

        // Update the department code if it is not null or empty
        if (Objects.nonNull(department.getDepartmentCode())
                && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            existingDepartment.setDepartmentCode(department.getDepartmentCode());
        }

        // Update the department address if it is not null or empty
        if (Objects.nonNull(department.getDepartmentAddress())
                && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            existingDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }

        // Save the updated department in the repository and return it
        return departmentRepository.save(existingDepartment);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByDepartmentNameIgnoreCase(name);
    }

}
