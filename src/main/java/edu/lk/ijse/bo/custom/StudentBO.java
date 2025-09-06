package edu.lk.ijse.bo.custom;

import edu.lk.ijse.bo.SuperBO;
import edu.lk.ijse.dto.StudentDto;

import java.sql.SQLException;
import java.util.List;

public interface StudentBO extends SuperBO {
    List<StudentDto> getStudents() throws SQLException;
    void saveStudent(StudentDto student) throws SQLException;
    void updateStudent(StudentDto student) throws SQLException;
    void deleteStudent(String id) throws SQLException;
    String getNextId() throws SQLException;
}
