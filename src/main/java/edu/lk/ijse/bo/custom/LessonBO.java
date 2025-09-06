package edu.lk.ijse.bo.custom;

import edu.lk.ijse.dto.InstructorDto;
import edu.lk.ijse.dto.LessonDto;

import java.sql.SQLException;
import java.util.List;

public interface LessonBO {
    List<LessonDto> getLessons() throws SQLException;
    void updateLesson(LessonDto lessonDto) throws SQLException;
    void deleteLesson(String id) throws SQLException;
    void saveLesson(LessonDto lessonDto) throws SQLException;


}
