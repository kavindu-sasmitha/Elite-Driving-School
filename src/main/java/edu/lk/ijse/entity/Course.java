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
@Table(name="courses")
public class Course {
    @Id
    private String courseId;
    @Column(nullable=false)
    private String courseName;
    @Column(nullable=false)
    private String courseDuration;
    @Column(nullable=false,length=12)
    private String courseFee;
    @Column(nullable=false)
    private String description;
}
