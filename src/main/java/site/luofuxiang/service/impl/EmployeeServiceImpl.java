package site.luofuxiang.service.impl;

import org.springframework.stereotype.Service;
import site.luofuxiang.entity.EmployeeEntity;
import site.luofuxiang.enums.ErrorType;
import site.luofuxiang.exception.ApiException;
import site.luofuxiang.form.EmployeeForm;
import site.luofuxiang.repository.EmployeeRepository;
import site.luofuxiang.service.EmployeeService;
import site.luofuxiang.util.EmployeeUtil;
import site.luofuxiang.util.UUIDUtil;
import site.luofuxiang.vo.EmployeeVO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeVO find(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorType.EMPLOYEE_NOT_EXISTS, id));
        return EmployeeUtil.entity2Vo(employeeEntity);
    }

    @Override
    public EmployeeVO save(EmployeeForm employee) {
        EmployeeEntity employeeEntity = EmployeeUtil.form2Entity(employee);
        if(employee.getId() == null){
            employeeEntity.setId(UUIDUtil.generateUUID());
        }
        employeeEntity = this.employeeRepository.save(employeeEntity);
        return EmployeeUtil.entity2Vo(employeeEntity);
    }

}
