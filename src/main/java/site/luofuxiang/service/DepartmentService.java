package site.luofuxiang.service;

import site.luofuxiang.dto.DepartmentDTO;
import site.luofuxiang.form.DepartmentForm;
import site.luofuxiang.vo.DepartmentVO;

public interface DepartmentService {

    DepartmentVO save(DepartmentForm departmentForm);

    DepartmentVO find(Long id);

    DepartmentDTO employees(Long id);
}
