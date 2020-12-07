package site.luofuxiang.service.impl;

import org.springframework.stereotype.Service;
import site.luofuxiang.dto.DepartmentDTO;
import site.luofuxiang.entity.DepartmentEntity;
import site.luofuxiang.entity.EmployeeEntity;
import site.luofuxiang.enums.ErrorType;
import site.luofuxiang.exception.ApiException;
import site.luofuxiang.form.DepartmentForm;
import site.luofuxiang.repository.DepartmentRepository;
import site.luofuxiang.repository.EmployeeRepository;
import site.luofuxiang.service.DepartmentService;
import site.luofuxiang.util.DepartmentUtil;
import site.luofuxiang.util.UUIDUtil;
import site.luofuxiang.vo.DepartmentVO;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private EmployeeRepository employeeRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public DepartmentVO save(DepartmentForm departmentForm) {
        DepartmentEntity departmentEntity = DepartmentUtil.form2Entity(departmentForm);
        if(departmentForm.getId() == null){
            departmentEntity.setId(UUIDUtil.generateUUID());
        }
        DepartmentEntity savedDepartmentEntity = departmentRepository.save(departmentEntity);
        return DepartmentUtil.entity2Vo(savedDepartmentEntity);
    }

    @Override
    public DepartmentVO find(Long id) {
        DepartmentEntity departmentEntity = departmentRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorType.DEPARTMENT_NOT_EXISTS, id));
        return DepartmentUtil.entity2Vo(departmentEntity);
    }

    @Override
    public DepartmentDTO employees(Long id) {
        DepartmentEntity departmentEntity = this.departmentRepository.findById(id).orElseThrow(() -> new ApiException(ErrorType.DEPARTMENT_NOT_EXISTS, id));
        DepartmentDTO departmentDTO = DepartmentUtil.entity2DTO(departmentEntity);
        // 没有查询到记录的情况下 Spring Jpa 返回空的 list，而不返回 null
        List<EmployeeEntity> employeeEntityList = this.employeeRepository.findAllByDepartmentId(id).orElse(Collections.emptyList());
        departmentDTO.setEmployeeEntities(employeeEntityList);
        return departmentDTO;
    }
}
