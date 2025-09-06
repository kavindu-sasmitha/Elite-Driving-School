package edu.lk.ijse.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseEnrollStudents {
    private String courseId;
    private String studentId;
    private String studentName;
    private String courseDuration;
    private String courseFee;
}
