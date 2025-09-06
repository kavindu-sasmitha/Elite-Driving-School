package edu.lk.ijse.bo.util;

import edu.lk.ijse.dto.InstructorDto;
import edu.lk.ijse.dto.LessonDto;
import edu.lk.ijse.dto.StudentDto;
import edu.lk.ijse.entity.Instructor;
import edu.lk.ijse.entity.Lesson;
import edu.lk.ijse.entity.Student;

public class EntityDTOConvertor {

    public StudentDto getStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(student.getStudentID());
        studentDto.setName(student.getName());
        studentDto.setEmail(student.getEmail());
        studentDto.setDate(student.getRegistrationDate());
        studentDto.setContact(student.getContact());
        studentDto.setAddress(student.getStudentAddress());
        studentDto.setDateOfBirth(student.getDateOfBirth());
        return studentDto;
    }
    public Student getStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setStudentID(studentDto.getStudentId());
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setRegistrationDate(studentDto.getDate());
        student.setContact(studentDto.getContact());
        student.setStudentAddress(studentDto.getAddress());
        student.setDateOfBirth(studentDto.getDateOfBirth());
        return student;
    }
    public Lesson getLesson(LessonDto lessonDto) {
        Lesson lesson = new Lesson();
        lesson.setLessonId(lessonDto.getLessonId());
        lesson.setLessonName(lessonDto.getLessonName());
        return lesson;
    }
    public LessonDto getLessonDto(Lesson lesson) {
        LessonDto lessonDto = new LessonDto();
        lessonDto.setLessonId(lesson.getLessonId());
        lessonDto.setLessonName(lesson.getLessonName());
        return lessonDto;
    }
    public Instructor getInstructor(InstructorDto instructorDto) {
        Instructor instructor = new Instructor();
        instructor.setInstructorId(instructorDto.getInstructorId());
        instructor.setInstructorName(instructorDto.getInstructorName());
        instructor.setSpecialization(instructorDto.getSpecialization());
        instructor.setDetails(instructorDto.getDetails());
        return instructor;
    }
    public InstructorDto getInstructorDto(Instructor instructor) {
        InstructorDto instructorDto = new InstructorDto();
        instructorDto.setInstructorId(instructor.getInstructorId());
        instructorDto.setInstructorName(instructor.getInstructorName());
        instructorDto.setSpecialization(instructor.getSpecialization());
        instructorDto.setDetails(instructor.getDetails());
        return instructorDto;
    }


}
