package edu.icet.elite.bo;

import edu.icet.elite.dao.*;
import edu.icet.elite.dto.LessonDto;
import edu.icet.elite.entity.Course;
import edu.icet.elite.entity.Instructor;
import edu.icet.elite.entity.Lesson;
import edu.icet.elite.entity.Student;
import edu.icet.elite.exception.SchedulingConflictException;

import java.util.List;
import java.util.stream.Collectors;

public class LessonBoImpl implements LessonBo {

    private final LessonDao lessonDao = new LessonDaoImpl();
    private final StudentDao studentDao = new StudentDaoImpl();
    private final InstructorDao instructorDao = new InstructorDaoImpl();
    private final CourseDao courseDao = new CourseDaoImpl();

    @Override
    public void scheduleLesson(LessonDto lessonDto) throws SchedulingConflictException {
        Lesson lesson = mapToEntity(lessonDto);
        // Basic conflict check: In a real system, this would be more complex
        // e.g., checking instructor availability within a time range.
        // For now, we'll just save it.
        lessonDao.save(lesson);
    }

    @Override
    public void rescheduleLesson(Integer lessonId, LessonDto lessonDto) throws SchedulingConflictException {
        Lesson lesson = lessonDao.findById(lessonId)
                .orElseThrow(() -> new SchedulingConflictException("Lesson not found to reschedule."));

        // Update fields from DTO
        updateLessonFromDto(lesson, lessonDto);

        lessonDao.update(lesson);
    }

    @Override
    public void cancelLesson(Integer lessonId) {
        lessonDao.findById(lessonId).ifPresent(lesson -> {
            lesson.setStatus("CANCELED");
            lessonDao.update(lesson);
        });
    }

    @Override
    public List<LessonDto> getAllLessons() {
        return lessonDao.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<LessonDto> getLessonsByStudent(Integer studentId) {
        // This requires a new DAO method. For now, filter in memory.
        return getAllLessons().stream()
                .filter(lesson -> lesson.getStudentId().equals(studentId))
                .collect(Collectors.toList());
    }

    private LessonDto mapToDto(Lesson lesson) {
        return new LessonDto(
                lesson.getLessonId(),
                lesson.getStudent().getStudentId(),
                lesson.getInstructor().getInstructorId(),
                lesson.getCourse().getCourseId(),
                lesson.getScheduledTime(),
                lesson.getStatus()
        );
    }

    private Lesson mapToEntity(LessonDto lessonDto) throws SchedulingConflictException {
        Student student = studentDao.findById(lessonDto.getStudentId())
                .orElseThrow(() -> new SchedulingConflictException("Student not found."));
        Instructor instructor = instructorDao.findById(lessonDto.getInstructorId())
                .orElseThrow(() -> new SchedulingConflictException("Instructor not found."));
        Course course = courseDao.findById(lessonDto.getCourseId())
                .orElseThrow(() -> new SchedulingConflictException("Course not found."));

        Lesson lesson = new Lesson();
        lesson.setStudent(student);
        lesson.setInstructor(instructor);
        lesson.setCourse(course);
        lesson.setScheduledTime(lessonDto.getScheduledTime());
        lesson.setStatus(lessonDto.getStatus());
        return lesson;
    }

    private void updateLessonFromDto(Lesson lesson, LessonDto lessonDto) throws SchedulingConflictException {
        // This helper updates an existing lesson entity from a DTO
        Student student = studentDao.findById(lessonDto.getStudentId())
                .orElseThrow(() -> new SchedulingConflictException("Student not found."));
        Instructor instructor = instructorDao.findById(lessonDto.getInstructorId())
                .orElseThrow(() -> new SchedulingConflictException("Instructor not found."));
        Course course = courseDao.findById(lessonDto.getCourseId())
                .orElseThrow(() -> new SchedulingConflictException("Course not found."));

        lesson.setStudent(student);
        lesson.setInstructor(instructor);
        lesson.setCourse(course);
        lesson.setScheduledTime(lessonDto.getScheduledTime());
        lesson.setStatus(lessonDto.getStatus());
    }
}
