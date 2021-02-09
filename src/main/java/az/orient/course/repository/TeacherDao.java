package az.orient.course.repository;

import az.orient.course.entity.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TeacherDao  extends CrudRepository<Teacher,Long> {

    List<Teacher> findAllByActive(Integer active);

    Teacher findTeacherByIdAndActive(Long id,Integer active);
}
