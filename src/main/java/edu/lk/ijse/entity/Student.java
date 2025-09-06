package edu.lk.ijse.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="students")
public class Student {
    @Id
    private String StudentID;
    @Column(nullable = false)
    private String  name;
    @Column(nullable = false)
    private String dateOfBirth;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false,unique = true)
    private String contact;
    @Column(nullable = false)
    private String StudentAddress;
    @Column(nullable = false)
    private String registrationDate;

}
