package com.sampleendpoint.department.controller;


import java.util.List;



import com.sampleendpoint.department.entity.department;
import com.sampleendpoint.department.service.DepartmentService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class departmentController {

    @Autowired private
    DepartmentService departmentService;


    //  for Save operation
    @PostMapping("/departments")

    public department saveDepartment(
            @Valid @RequestBody department department)
    {
               return departmentService.saveDepartment(department);
    }

    // for Read operation
    @GetMapping("/departments")

    public List<department> fetchDepartmentList()
    {
        return departmentService.fetchDepartmentList();
    }

    // for Update operation

    @PutMapping("/departments/{id}")

    public department
    updateDepartment(@RequestBody department department,
                     @PathVariable("id") Long departmentId)
    {
        return departmentService.updateDepartment(
                department, departmentId);
    }

    // for Delete operation
    @DeleteMapping("/departments/{id}")

    public String deleteDepartmentById(@PathVariable("id")
                                       Long departmentId)
    {
        departmentService.deleteDepartmentById(
                departmentId);
        return "Deleted Successfully";
    }

}
