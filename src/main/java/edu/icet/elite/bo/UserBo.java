package edu.icet.elite.bo;

import edu.icet.elite.dto.UserDto;
import edu.icet.elite.exception.InvalidCredentialsException;

public interface UserBo {
    UserDto login(UserDto userDto) throws InvalidCredentialsException;
    void registerUser(UserDto userDto);
    void updateUser(UserDto userDto);
    void changePassword(String username, String oldPassword, String newPassword) throws InvalidCredentialsException;
}
