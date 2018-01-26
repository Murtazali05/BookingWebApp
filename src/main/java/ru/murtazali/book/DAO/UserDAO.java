package ru.murtazali.book.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.murtazali.book.model.User;

import java.util.List;
@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

}
