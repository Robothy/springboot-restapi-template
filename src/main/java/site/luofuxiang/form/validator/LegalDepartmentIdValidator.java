package site.luofuxiang.form.validator;

import org.springframework.stereotype.Component;
import site.luofuxiang.context.ApiContext;
import site.luofuxiang.exception.ApiException;
import site.luofuxiang.form.DepartmentForm;
import site.luofuxiang.service.DepartmentService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class LegalDepartmentIdValidator implements ConstraintValidator<ValidDepartmentForm, DepartmentForm> {

    private ApiContext apiContext;

    private DepartmentService departmentService;

    public LegalDepartmentIdValidator(DepartmentService departmentService, ApiContext apiContext) {
        this.departmentService = departmentService;
        this.apiContext = apiContext;
    }

    @Override
    public boolean isValid(DepartmentForm value, ConstraintValidatorContext context) {
        if(value.getId() != null){
            try{
                this.departmentService.find(value.getId());
            }catch (ApiException e){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(apiContext.message(e.getErrorType().getMessageKey(), e.getArgs()))
                        .addConstraintViolation();
                return false;
            }
        }
        return true;
    }

}
