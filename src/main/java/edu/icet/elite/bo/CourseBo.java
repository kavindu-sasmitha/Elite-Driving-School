package edu.icet.elite.bo;

import edu.icet.elite.dto.CourseDto;
import java.util.List;

public interface CourseBo {
    void addCourse(CourseDto courseDto);
    CourseDto getCourseById(String id);
    List<CourseDto> getAllCourses();
    void updateCourse(CourseDto courseDto);
    void deleteCourse(String id);
}
