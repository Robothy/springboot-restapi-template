package site.luofuxiang.service;

import org.springframework.stereotype.Service;
import site.luofuxiang.form.EmployeeForm;
import site.luofuxiang.vo.EmployeeVO;

@Service
public interface EmployeeService {

    /**
     * 根据 ID 查找 Employee
     * @param id 员工 ID
     * @return 一个 EmployeeVO（这里因为没有复杂的数据结构，所以直接就 VO 和 From 进行转换，不涉及 DTO）
     */
    EmployeeVO find(Long id);

    /**
     * 保存一个员工。
     * 如果 id 为空，则新建；
     * 若不为空，则保存，保存的时候需要校验 ID 是否存在，不能给用户自己创建 ID 的机会
     * @param employee 用户信息
     * @return 一个用户的信息（含 ID）
     */
    EmployeeVO save(EmployeeForm employee);

}
