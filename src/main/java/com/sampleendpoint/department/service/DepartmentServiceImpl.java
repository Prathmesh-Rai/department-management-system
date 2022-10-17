package com.sampleendpoint.department.service;


import java.util.List;
import java.util.Objects;

import com.sampleendpoint.department.entity.department;
import com.sampleendpoint.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service ;


@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public department saveDepartment(department dep)
    {
        return departmentRepository.save(dep);
    }

    // Read operation
    @Override public List<department> fetchDepartmentList()
    {

        return (List<department>)
                departmentRepository.findAll();
    }

    // Update operation
    @Override
    public department
    updateDepartment(department dep,
                     Long departmentId)
    {

        department depDB
                = departmentRepository.findById(departmentId)
                .get();

        if (Objects.nonNull(dep.getDepartmentName())
                && !"".equalsIgnoreCase(
                dep.getDepartmentName())) {
            depDB.setDepartmentName(
                    dep.getDepartmentName());
        }

        if (Objects.nonNull(
                dep.getDepartmentAddress())
                && !"".equalsIgnoreCase(
                dep.getDepartmentAddress())) {
            depDB.setDepartmentAddress(
                    dep.getDepartmentAddress());
        }
        if (Objects.nonNull(dep.getDepartmentCode())
                && !"".equalsIgnoreCase(
                dep.getDepartmentCode())) {
            depDB.setDepartmentCode(
                    dep.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    // Delete operation
    @Override
    public void deleteDepartmentById(Long departmentId)
    {
        departmentRepository.deleteById(departmentId);
    }
}
