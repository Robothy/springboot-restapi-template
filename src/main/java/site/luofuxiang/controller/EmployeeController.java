package site.luofuxiang.controller;

import org.springframework.web.bind.annotation.*;
import site.luofuxiang.form.EmployeeForm;
import site.luofuxiang.service.EmployeeService;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public Object save(@Valid @RequestBody EmployeeForm employee){
        return employeeService.save(employee);
    }

    @GetMapping("/employee/{id}")
    public Object query(@Valid @NotEmpty @PathVariable("id") Long id){
        return employeeService.find(id);
    }
}
