package site.luofuxiang.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import site.luofuxiang.entity.converter.DepartmentIdConverter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Table(name = "DEPARTMENT")
@Entity
public class DepartmentEntity {

    @Id
    @Convert(converter = DepartmentIdConverter.class)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

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

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(null == obj) return false;
        if(!(obj instanceof DepartmentEntity)) return false;
        DepartmentEntity departmentEntity = (DepartmentEntity) obj;
        return departmentEntity.id.equals(this.id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
