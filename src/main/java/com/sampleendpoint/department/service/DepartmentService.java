package com.sampleendpoint.department.service;

import com.sampleendpoint.department.entity.department;

import java.util.List;

public interface DepartmentService {
    department saveDepartment(department department);


    List<department> fetchDepartmentList();

    department updateDepartment(department department,
                                Long departmentId);

    void deleteDepartmentById(Long departmentId);
}
