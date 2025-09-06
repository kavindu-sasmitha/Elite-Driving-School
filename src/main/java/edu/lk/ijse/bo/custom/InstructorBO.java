package edu.lk.ijse.bo.custom;

import edu.lk.ijse.dto.InstructorDto;

import java.sql.SQLException;
import java.util.List;

public interface InstructorBO {
    void saveInstructor(InstructorDto instructor) throws SQLException;
    void updateInstructor(InstructorDto instructor) throws SQLException;
    void deleteInstructor(String id) throws SQLException;
    List<InstructorDto> getInstructors();
}
