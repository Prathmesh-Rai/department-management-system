package com.sampleendpoint.department.repository;

import com.sampleendpoint.department.entity.department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<department, Long> {

}
