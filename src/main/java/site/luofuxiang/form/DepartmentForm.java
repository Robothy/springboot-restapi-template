package site.luofuxiang.form;

import site.luofuxiang.form.validator.ValidDepartmentForm;

import javax.validation.constraints.NotEmpty;

@ValidDepartmentForm
public class DepartmentForm {

    private Long id;

    @NotEmpty(message = "departmentNameCannotBeEmpty")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
