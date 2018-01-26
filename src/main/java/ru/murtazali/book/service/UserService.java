package ru.murtazali.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.murtazali.book.DAO.UserDAO;
import ru.murtazali.book.model.User;

import java.util.List;

@Service
public class UserService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }
}
