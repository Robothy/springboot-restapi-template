package site.luofuxiang.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SALARY")
    private BigDecimal salary;

    @Column(name = "CREATE_TIME")
    @CreationTimestamp
    private Date createTime;

    @Column(name = "UPDATE_TIME")
    @UpdateTimestamp
    private Date updateTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (!(object instanceof EmployeeEntity)) return false;
        EmployeeEntity employeeEntity = (EmployeeEntity) object;
        return this.id.equals(employeeEntity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
