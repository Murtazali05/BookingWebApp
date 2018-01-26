package ru.murtazali.book.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.murtazali.book.model.Book;

import java.util.List;

public interface BookDAO extends JpaRepository<Book, Integer> {

}
