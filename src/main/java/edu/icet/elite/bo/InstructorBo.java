package edu.icet.elite.bo;

import edu.icet.elite.dto.InstructorDto;
import java.util.List;

public interface InstructorBo {
    void addInstructor(InstructorDto instructorDto);
    InstructorDto getInstructorById(Integer id);
    List<InstructorDto> getAllInstructors();
    void updateInstructor(InstructorDto instructorDto);
    void deleteInstructor(Integer id);
}
