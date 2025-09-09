package edu.icet.elite.dao;

import edu.icet.elite.entity.Student;
import java.util.List;
import java.util.Optional;

public interface StudentDao {
    void save(Student student);
    Optional<Student> findById(Integer id);
    List<Student> findAll();
    void update(Student student);
    void delete(Student student);
    List<Student> findAllWithCourses(); // For requirement 4
    List<Student> findStudentsEnrolledInAllCourses(); // For requirement 2
}
