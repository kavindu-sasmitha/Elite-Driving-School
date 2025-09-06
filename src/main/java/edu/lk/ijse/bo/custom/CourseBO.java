package edu.lk.ijse.bo.custom;

import edu.lk.ijse.dto.CourseDto;

import java.util.List;

public interface CourseBO {
List<CourseDto>getCourses();
void addCourse(CourseDto course);
void updateCourse(CourseDto course);
void deleteCourse(String id);
}
