package edu.icet.elite.bo;

import edu.icet.elite.dto.StudentDto;
import edu.icet.elite.exception.RegistrationException;

import java.util.List;

public interface StudentBo {
    void registerStudent(StudentDto studentDto) throws RegistrationException;
    StudentDto getStudentById(Integer id);
    List<StudentDto> getAllStudents();
    void updateStudent(StudentDto studentDto) throws RegistrationException;
    void deleteStudent(Integer id);
    List<StudentDto> getStudentsWithCourses();
    List<StudentDto> getStudentsEnrolledInAllCourses();
}
