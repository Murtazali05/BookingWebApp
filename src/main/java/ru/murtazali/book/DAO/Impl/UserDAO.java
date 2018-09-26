package ru.murtazali.book.DAO.Impl;

import org.springframework.stereotype.Repository;
import ru.murtazali.book.DAO.AbstractDAOImpl;
import ru.murtazali.book.model.User;

import java.util.List;

@Repository
public class UserDAO extends AbstractDAOImpl<User, Integer> {

    public UserDAO() {
        super(User.class);
    }

    public List<User> getUsers() {
        return list();
    }

}