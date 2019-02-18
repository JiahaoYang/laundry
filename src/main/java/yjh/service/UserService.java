package yjh.service;

import org.springframework.stereotype.Service;
import yjh.dao.UserDAO;
import yjh.model.User;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    UserDAO userDAO;

    public User getById(int userId) {
        return userDAO.getById(userId);
    }

    public User getByName(String username) {
        return userDAO.getByName(username);
    }

    public int addUser(User user) {
        return userDAO.addUser(user);
    }

    public int updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public boolean isExist(String username) {
        return getByName(username) != null;
    }

    public User login(String username, String password) {
        User user = userDAO.getByName(username);
        if (user != null && user.getPassword().equals(password))
            return user;
        return null;
    }
}
