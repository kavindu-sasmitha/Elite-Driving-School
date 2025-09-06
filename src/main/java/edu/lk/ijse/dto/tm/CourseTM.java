package edu.lk.ijse.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseTM {
    private String courseId;
    private String courseName;
    private String courseDuration;
    private String courseFee;
    private String courseDescription;
}
