package site.luofuxiang.form;

import site.luofuxiang.form.validator.ValidEmployeeForm;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@ValidEmployeeForm
public class EmployeeForm {

    private Long id;

    private Long departmentId;

    @NotEmpty(message = "employeeNameCannotBeEmpty")
    private String name;

    private BigDecimal salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
