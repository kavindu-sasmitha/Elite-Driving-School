package edu.icet.elite.bo;

import edu.icet.elite.dao.CourseDao;
import edu.icet.elite.dao.CourseDaoImpl;
import edu.icet.elite.dto.CourseDto;
import edu.icet.elite.entity.Course;

import java.util.List;
import java.util.stream.Collectors;

public class CourseBoImpl implements CourseBo {

    private final CourseDao courseDao = new CourseDaoImpl();

    @Override
    public void addCourse(CourseDto courseDto) {
        Course course = new Course(
                courseDto.getCourseId(),
                courseDto.getCourseName(),
                courseDto.getDuration(),
                courseDto.getFee()
        );
        courseDao.save(course);
    }

    @Override
    public CourseDto getCourseById(String id) {
        return courseDao.findById(id)
                .map(course -> new CourseDto(
                        course.getCourseId(),
                        course.getCourseName(),
                        course.getDuration(),
                        course.getFee()))
                .orElse(null);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        return courseDao.findAll().stream()
                .map(course -> new CourseDto(
                        course.getCourseId(),
                        course.getCourseName(),
                        course.getDuration(),
                        course.getFee()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateCourse(CourseDto courseDto) {
        Course course = new Course(
                courseDto.getCourseId(),
                courseDto.getCourseName(),
                courseDto.getDuration(),
                courseDto.getFee()
        );
        courseDao.update(course);
    }

    @Override
    public void deleteCourse(String id) {
        courseDao.findById(id).ifPresent(courseDao::delete);
    }
}
