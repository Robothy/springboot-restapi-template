package site.luofuxiang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.luofuxiang.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    Optional<List<EmployeeEntity>> findAllByDepartmentId(Long departmentId);

}
