package az.orient.course.repository;

import az.orient.course.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends CrudRepository<Student,Long> {
 List<Student> findAllByActive(Integer active);
}
