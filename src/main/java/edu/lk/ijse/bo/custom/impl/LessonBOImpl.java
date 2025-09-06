package edu.lk.ijse.bo.custom.impl;

import edu.lk.ijse.bo.custom.LessonBO;
import edu.lk.ijse.bo.util.EntityDTOConvertor;
import edu.lk.ijse.dao.DAOFactory;
import edu.lk.ijse.dao.DAOType;
import edu.lk.ijse.dao.custom.LessonDAO;
import edu.lk.ijse.dto.LessonDto;
import edu.lk.ijse.dto.StudentDto;
import edu.lk.ijse.entity.Lesson;
import edu.lk.ijse.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LessonBOImpl implements LessonBO {
    private final LessonDAO lessonDAO= DAOFactory.getInstance().getDAO(DAOType.LESSON);
    private final EntityDTOConvertor convertor = new EntityDTOConvertor();
    @Override
    public List<LessonDto> getLessons() throws SQLException {
   return null;
    }

    @Override
    public void updateLesson(LessonDto lessonDto) throws SQLException {
        Lesson lesson=convertor.getLesson(lessonDto);
        boolean update=lessonDAO.update(lesson);

    }

    @Override
    public void deleteLesson(String id) throws SQLException {
        boolean delete=lessonDAO.delete(id);

    }

    @Override
    public void saveLesson(LessonDto lessonDto) throws SQLException {
        Lesson lesson=convertor.getLesson(lessonDto);
        boolean save=lessonDAO.save(lesson);

    }
}
