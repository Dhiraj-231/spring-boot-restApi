package com.springboot.firstproject.Entity;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Department_details")
public class Department {
    @Id
    private long departmentId;
    @Column(name = "department_name")
    @NotBlank(message = "Department name cannot be blank")
    @Length(min = 2, max = 10, message = "Department name must be between 2 and 10 characters")
    private String departmentName;
    @Column(name = "department_address")
    private String departmentAddress;
    @Column(name = "department_code")
    private String departmentCode;

}
