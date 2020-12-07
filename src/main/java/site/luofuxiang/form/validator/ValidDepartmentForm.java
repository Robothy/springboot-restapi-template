package site.luofuxiang.form.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.TYPE})
@Repeatable(ValidDepartmentForm.List.class)
@Constraint(validatedBy = LegalDepartmentIdValidator.class)
public @interface ValidDepartmentForm {

    String message() default "invalidDepartmentForm";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    // 确保 ValidDepartmentForm 能够重复加在同一个位置（设置不同的参数）
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.PARAMETER, ElementType.TYPE})
    @Documented
    @interface List {
        ValidDepartmentForm[] value();
    }
}
