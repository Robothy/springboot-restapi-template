package site.luofuxiang.form.validator;

import org.springframework.stereotype.Component;
import site.luofuxiang.form.EmployeeForm;
import site.luofuxiang.service.EmployeeService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 合法的 Employee ID 校验器，用来校验表单中的 Employee ID 是否合法。
 * ID 只能通过系统生成，用户不能通过 API 提交一个数据库不存在的 Employee ID
 */
@Component
public class LegalEmployeeIdValidator implements ConstraintValidator<ValidEmployeeForm, EmployeeForm> {

    private EmployeeService employeeService;

    public LegalEmployeeIdValidator(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public boolean isValid(EmployeeForm value, ConstraintValidatorContext context) {
        // id 不存在的话会抛出一个 ApiException
        if(null != value.getId()){
            this.employeeService.find(value.getId());
        }
        return true;
    }
}
