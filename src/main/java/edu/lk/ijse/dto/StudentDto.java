package edu.lk.ijse.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class StudentDto {
    private String studentId;
    private String name;
    private String dateOfBirth;
    private String email;
    private String contact;
    private String address;
    private String date;
}
