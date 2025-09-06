package edu.lk.ijse.bo.custom.impl;

import edu.lk.ijse.bo.custom.InstructorBO;
import edu.lk.ijse.bo.util.EntityDTOConvertor;
import edu.lk.ijse.dao.DAOFactory;
import edu.lk.ijse.dao.DAOType;
import edu.lk.ijse.dao.custom.InstructorDAO;
import edu.lk.ijse.dto.InstructorDto;
import edu.lk.ijse.entity.Instructor;

import java.sql.SQLException;
import java.util.List;

public class InstructorBOImpl implements InstructorBO {
    private final InstructorDAO instructorDAO= DAOFactory.getInstance().getDAO(DAOType.INSTRUCTOR);
    private final EntityDTOConvertor convertor = new EntityDTOConvertor();
    @Override
    public void saveInstructor(InstructorDto instructorDto) throws SQLException {
        Instructor instructor=convertor.getInstructor(instructorDto);
        boolean save=instructorDAO.save(instructor);

    }

    @Override
    public void updateInstructor(InstructorDto instructorDto) throws SQLException {
        Instructor instructor=convertor.getInstructor(instructorDto);
        boolean update=instructorDAO.update(instructor);

    }

    @Override
    public void deleteInstructor(String id) throws SQLException {
        boolean delete=instructorDAO.delete(id);

    }

    @Override
    public List<InstructorDto> getInstructors() {
        return List.of();
    }
}
