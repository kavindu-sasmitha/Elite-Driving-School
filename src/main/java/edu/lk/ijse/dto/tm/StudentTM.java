package edu.lk.ijse.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentTM {
    private String studentId;
    private String studentName;
    private String dateOfBirth;
    private String email;
    private String contact;
    private String address;
    private String regiDate;
}
