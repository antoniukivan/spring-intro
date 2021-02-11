package spring.intro.dao;

import java.util.List;
import java.util.Optional;
import spring.intro.model.User;

public interface UserDao {
    void add(User user);

    List<User> getAllUsers();

    Optional<User> getById(Long userId);
}
