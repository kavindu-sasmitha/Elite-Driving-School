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
@Table(name="lessons")
public class Lesson {
    @Id
    private String lessonId;
    @Column(nullable=false)
    private String lessonName;
}
