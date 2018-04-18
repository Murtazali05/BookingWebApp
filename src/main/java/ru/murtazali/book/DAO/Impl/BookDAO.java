package ru.murtazali.book.DAO.Impl;

import org.springframework.stereotype.Repository;
import ru.murtazali.book.DAO.AbstractDAOImpl;
import ru.murtazali.book.model.Book;

import java.util.List;

@Repository
public class BookDAO extends AbstractDAOImpl<Book, Integer> {

    public BookDAO() {
        super(Book.class);
    }

    public List<Book> getBooks() {
        return list();
    }

}
