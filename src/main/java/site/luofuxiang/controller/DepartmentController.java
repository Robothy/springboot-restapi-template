package site.luofuxiang.controller;

import org.springframework.web.bind.annotation.*;
import site.luofuxiang.dto.DepartmentDTO;
import site.luofuxiang.form.DepartmentForm;
import site.luofuxiang.service.DepartmentService;
import site.luofuxiang.util.DepartmentUtil;
import site.luofuxiang.vo.DepartmentVO;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

@RestController
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department/{id}")
    public DepartmentVO find(@Valid @NotEmpty @PositiveOrZero @PathVariable("id") Long id){
        return this.departmentService.find(id);
    }

    @PostMapping("/department")
    public DepartmentVO save(@Valid @RequestBody DepartmentForm departmentForm){
        return this.departmentService.save(departmentForm);
    }

    @GetMapping("/department/{id}/employees")
    public DepartmentVO employees(@Valid @NotEmpty @PositiveOrZero @PathVariable("id") Long id){
        DepartmentDTO deptDTO = departmentService.employees(id);
        return DepartmentUtil.dto2Vo(deptDTO);
    }
}
