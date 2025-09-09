package edu.icet.elite.bo;

import edu.icet.elite.dao.UserDao;
import edu.icet.elite.dao.UserDaoImpl;
import edu.icet.elite.dto.UserDto;
import edu.icet.elite.entity.User;
import edu.icet.elite.exception.InvalidCredentialsException;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Optional;

public class UserBoImpl implements UserBo {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public UserDto login(UserDto userDto) throws InvalidCredentialsException {
        Optional<User> userOptional = userDao.findByUsername(userDto.getUsername());

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (BCrypt.checkpw(userDto.getPassword(), user.getPassword())) {
                return new UserDto(user.getUsername(), null, user.getRole()); // Don't send password back
            }
        }
        throw new InvalidCredentialsException("Invalid username or password.");
    }

    @Override
    public void registerUser(UserDto userDto) {
        String hashedPassword = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
        User user = new User(userDto.getUsername(), hashedPassword, userDto.getRole());
        userDao.save(user);
    }

    @Override
    public void updateUser(UserDto userDto) {
        // This method should probably not allow password changes directly.
        // That should be handled by a specific changePassword method.
        // For now, it updates username and role.
        Optional<User> userOptional = userDao.findByUsername(userDto.getUsername());
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setRole(userDto.getRole());
            // In a real app, you might want to check if the username is being changed
            // which would require more complex logic (e.g., creating a new user, deleting old one).
            // For now, we assume username is the key and doesn't change.
            userDao.update(user);
        }
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword) throws InvalidCredentialsException {
        Optional<User> userOptional = userDao.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (BCrypt.checkpw(oldPassword, user.getPassword())) {
                String hashedNewPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());
                user.setPassword(hashedNewPassword);
                userDao.update(user);
                return;
            }
        }
        throw new InvalidCredentialsException("Invalid credentials. Password could not be changed.");
    }
}
