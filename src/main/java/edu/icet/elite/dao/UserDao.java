package edu.icet.elite.dao;

import edu.icet.elite.entity.User;
import java.util.Optional;

public interface UserDao {
    void save(User user);
    Optional<User> findByUsername(String username);
    void update(User user);
    void delete(User user);
}
