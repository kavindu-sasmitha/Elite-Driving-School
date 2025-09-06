package edu.lk.ijse.bo.custom.impl;

import edu.lk.ijse.bo.custom.StudentBO;
import edu.lk.ijse.bo.util.EntityDTOConvertor;
import edu.lk.ijse.dao.DAOFactory;
import edu.lk.ijse.dao.DAOType;
import edu.lk.ijse.dao.custom.StudentDAO;
import edu.lk.ijse.dto.StudentDto;
import edu.lk.ijse.entity.Student;

import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {
    private final StudentDAO studentDAO= DAOFactory.getInstance().getDAO(DAOType.STUDENT);
    private final EntityDTOConvertor convertor = new EntityDTOConvertor();
    @Override
    public List<StudentDto> getStudents() throws SQLException {
        List<Student> students = studentDAO.getAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students) {
            studentDtos.add(convertor.getStudentDto(student));
        }
        return studentDtos;
    }

    @Override
    public void saveStudent(StudentDto student) throws SQLException {
        Student student1 = convertor.getStudent(student);
        boolean save = studentDAO.save(student1);

    }

    @Override
    public void updateStudent(StudentDto student) throws SQLException {
        Student student1 = convertor.getStudent(student);
        boolean update=studentDAO.update(student1);

    }

    @Override
    public void deleteStudent(String id) throws SQLException {
        boolean delete=studentDAO.delete(id);

    }

    @Override
    public String getNextId() throws SQLException {
        String lastId = studentDAO.getLastId();
        char tableChar = 'C';
        if (lastId != null) {
            String lastIdNumberString = lastId.substring(1);
            int lastIdNumber = Integer.parseInt(lastIdNumberString);
            int nextIdNumber = lastIdNumber + 1;
            return String.format(tableChar + "%03d", nextIdNumber);
        }
        return tableChar + "001";

    }
}
