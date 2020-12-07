package site.luofuxiang.util;

import site.luofuxiang.entity.EmployeeEntity;
import site.luofuxiang.form.EmployeeForm;
import site.luofuxiang.vo.EmployeeVO;

public class EmployeeUtil {

    public static EmployeeEntity vo2Entity(EmployeeVO employeeVO){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employeeVO.getId());
        employeeEntity.setDepartmentId(employeeVO.getDepartment().getId());
        employeeEntity.setName(employeeVO.getName());
        employeeEntity.setSalary(employeeVO.getSalary());
        return employeeEntity;
    }

    /**
     * 将 Employee 实体类对象转化为 EmployeeVO 对象。
     * 注意： 转换的时候只转换共有的属性，某些非共有属性默认为空
     * Employee.departmentId 不能转换成 EmployeeVO.DepartmentVO
     */
    public static EmployeeVO entity2Vo(EmployeeEntity employeeEntity){
        EmployeeVO employeeVO = new EmployeeVO();
        employeeVO.setId(employeeEntity.getId());
        employeeVO.setName(employeeEntity.getName());
        employeeVO.setSalary(employeeEntity.getSalary());
        return employeeVO;
    }

    public static EmployeeEntity form2Entity(EmployeeForm employeeForm){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employeeForm.getId());
        employeeEntity.setName(employeeForm.getName());
        employeeEntity.setDepartmentId(employeeForm.getDepartmentId());
        return employeeEntity;
    }

}
