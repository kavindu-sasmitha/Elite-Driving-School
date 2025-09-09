package edu.icet.elite.bo;

import edu.icet.elite.dao.InstructorDao;
import edu.icet.elite.dao.InstructorDaoImpl;
import edu.icet.elite.dto.InstructorDto;
import edu.icet.elite.entity.Instructor;

import java.util.List;
import java.util.stream.Collectors;

public class InstructorBoImpl implements InstructorBo {

    private final InstructorDao instructorDao = new InstructorDaoImpl();

    @Override
    public void addInstructor(InstructorDto instructorDto) {
        instructorDao.save(mapToEntity(instructorDto));
    }

    @Override
    public InstructorDto getInstructorById(Integer id) {
        return instructorDao.findById(id).map(this::mapToDto).orElse(null);
    }

    @Override
    public List<InstructorDto> getAllInstructors() {
        return instructorDao.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void updateInstructor(InstructorDto instructorDto) {
        Instructor instructor = mapToEntity(instructorDto);
        instructor.setInstructorId(instructorDto.getInstructorId());
        instructorDao.update(instructor);
    }

    @Override
    public void deleteInstructor(Integer id) {
        instructorDao.findById(id).ifPresent(instructorDao::delete);
    }

    private InstructorDto mapToDto(Instructor instructor) {
        return new InstructorDto(
                instructor.getInstructorId(),
                instructor.getName(),
                instructor.getContactNumber(),
                instructor.getEmail()
        );
    }

    private Instructor mapToEntity(InstructorDto instructorDto) {
        return new Instructor(
                instructorDto.getInstructorId(),
                instructorDto.getName(),
                instructorDto.getContactNumber(),
                instructorDto.getEmail()
        );
    }
}
