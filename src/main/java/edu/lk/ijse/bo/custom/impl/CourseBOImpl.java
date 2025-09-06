package edu.lk.ijse.bo.custom.impl;

import edu.lk.ijse.bo.custom.CourseBO;
import edu.lk.ijse.dto.CourseDto;

import java.util.List;

public class CourseBOImpl implements CourseBO {
    @Override
    public List<CourseDto> getCourses() {
        return List.of();
    }

    @Override
    public void addCourse(CourseDto course) {

    }

    @Override
    public void updateCourse(CourseDto course) {

    }

    @Override
    public void deleteCourse(String id) {

    }
}
