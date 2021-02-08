package spring.intro.service;

import java.util.List;
import spring.intro.dao.UserDao;
import spring.intro.model.User;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.getAllUsers();
    }
}
