package edu.lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InstructorDto {
    private String instructorId;
    private String instructorName;
    private String specialization;
    private String details;
}
