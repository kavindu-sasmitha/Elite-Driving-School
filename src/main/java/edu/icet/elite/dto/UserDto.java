package edu.icet.elite.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String username;
    private String password; // This will be plain text from the UI
    private String role;
}
