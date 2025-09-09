package edu.icet.elite.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "users") // Using "users" because "user" is often a reserved keyword in SQL
public class User {
    @Id
    private String username;
    private String password;
    private String role; // "Admin" or "Receptionist"
}
