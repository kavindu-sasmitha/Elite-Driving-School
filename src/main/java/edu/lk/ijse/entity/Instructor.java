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
@Table(name="instructors")
public class Instructor {
    @Id
    private String instructorId;
    @Column(nullable=false)
    private String instructorName;
    @Column(nullable=false)
    private String specialization;
    @Column(nullable=true)
    private String details;

}
