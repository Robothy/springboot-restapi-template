package site.luofuxiang.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DepartmentVO {

    private Long id;

    private String name;

    private List<EmployeeVO> employees;

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

    public List<EmployeeVO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeVO> employees) {
        this.employees = employees;
    }
}
