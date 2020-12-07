package site.luofuxiang.util;

import site.luofuxiang.dto.DepartmentDTO;
import site.luofuxiang.entity.DepartmentEntity;
import site.luofuxiang.entity.EmployeeEntity;
import site.luofuxiang.form.DepartmentForm;
import site.luofuxiang.vo.DepartmentVO;
import site.luofuxiang.vo.EmployeeVO;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentUtil {

    /**
     * DepartmentVO 转 DepartmentDTO，二者通用字段的转换
     */
    public static DepartmentDTO vo2Dto(DepartmentVO departmentVO){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(departmentVO.getId());
        departmentDTO.setName(departmentVO.getName());
        if(departmentVO.getEmployees() == null){
            departmentDTO.setEmployeeEntities(null);
        }else{
            List<EmployeeEntity> employeeEntities = departmentVO.getEmployees().stream()
                    .map(EmployeeUtil::vo2Entity)
                    .collect(Collectors.toList());
            departmentDTO.setEmployeeEntities(employeeEntities);
        }
        return departmentDTO;
    }

    public static DepartmentVO dto2Vo(DepartmentDTO departmentDTO){
        DepartmentVO departmentVO = new DepartmentVO();
        departmentVO.setId(departmentDTO.getId());
        departmentVO.setName(departmentDTO.getName());
        List<EmployeeVO> employees = departmentDTO.getEmployeeEntities().stream().map(EmployeeUtil::entity2Vo)
                .collect(Collectors.toList());
        departmentVO.setEmployees(employees);
        return departmentVO;
    }

    public static DepartmentEntity form2Entity(DepartmentForm departmentForm){
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(departmentForm.getId());
        departmentEntity.setName(departmentForm.getName());
        return departmentEntity;
    }

    public static DepartmentVO entity2Vo(DepartmentEntity departmentEntity){
        DepartmentVO departmentVO = new DepartmentVO();
        departmentVO.setId(departmentEntity.getId());
        departmentVO.setName(departmentEntity.getName());
        return departmentVO;
    }

    public static DepartmentDTO entity2DTO(DepartmentEntity departmentEntity){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(departmentEntity.getId());
        departmentDTO.setName(departmentEntity.getName());
        departmentDTO.setCreateTime(departmentEntity.getCreateTime());
        departmentDTO.setUpdateTime(departmentEntity.getUpdateTime());
        return departmentDTO;
    }

}
