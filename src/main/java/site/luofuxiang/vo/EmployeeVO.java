package site.luofuxiang.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeVO {

    private Long id;

    private String name;

    private BigDecimal salary;

    private DepartmentVO department;

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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public DepartmentVO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentVO department) {
        this.department = department;
    }
}
