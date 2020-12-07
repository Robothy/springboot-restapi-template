package site.luofuxiang.form.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.TYPE})
@Documented
@Constraint(validatedBy = {LegalEmployeeIdValidator.class})
public @interface ValidEmployeeForm {

    String message() default "invalidEmployeeForm";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
