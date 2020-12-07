package site.luofuxiang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.luofuxiang.entity.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

}
