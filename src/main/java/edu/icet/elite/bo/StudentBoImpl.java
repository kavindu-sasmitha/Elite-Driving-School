package edu.icet.elite.bo;

import edu.icet.elite.dao.CourseDao;
import edu.icet.elite.dao.CourseDaoImpl;
import edu.icet.elite.dao.StudentDao;
import edu.icet.elite.dao.StudentDaoImpl;
import edu.icet.elite.dto.StudentDto;
import edu.icet.elite.entity.Course;
import edu.icet.elite.entity.Student;
import edu.icet.elite.exception.RegistrationException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentBoImpl implements StudentBo {

    private final StudentDao studentDao = new StudentDaoImpl();
    private final CourseDao courseDao = new CourseDaoImpl();

    @Override
    public void registerStudent(StudentDto studentDto) throws RegistrationException {
        Student student = mapToEntity(studentDto);
        studentDao.save(student);
    }

    @Override
    public StudentDto getStudentById(Integer id) {
        return studentDao.findById(id).map(this::mapToDto).orElse(null);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return studentDao.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void updateStudent(StudentDto studentDto) throws RegistrationException {
        Student student = mapToEntity(studentDto);
        student.setStudentId(studentDto.getStudentId()); // Ensure ID is set for update
        studentDao.update(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentDao.findById(id).ifPresent(studentDao::delete);
    }

    @Override
    public List<StudentDto> getStudentsWithCourses() {
        return studentDao.findAllWithCourses().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<StudentDto> getStudentsEnrolledInAllCourses() {
        return studentDao.findStudentsEnrolledInAllCourses().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private StudentDto mapToDto(Student student) {
        Set<String> courseIds = student.getCourses().stream()
                .map(Course::getCourseId)
                .collect(Collectors.toSet());
        return new StudentDto(
                student.getStudentId(),
                student.getName(),
                student.getAddress(),
                student.getContactNumber(),
                student.getRegistrationDate(),
                courseIds
        );
    }

    private Student mapToEntity(StudentDto studentDto) throws RegistrationException {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setAddress(studentDto.getAddress());
        student.setContactNumber(studentDto.getContactNumber());
        student.setRegistrationDate(studentDto.getRegistrationDate());

        if (studentDto.getCourseIds() != null && !studentDto.getCourseIds().isEmpty()) {
            Set<Course> courses = new HashSet<>();
            for (String courseId : studentDto.getCourseIds()) {
                Course course = courseDao.findById(courseId)
                        .orElseThrow(() -> new RegistrationException("Course not found with ID: " + courseId));
                courses.add(course);
            }
            student.setCourses(courses);
        }
        return student;
    }
}
