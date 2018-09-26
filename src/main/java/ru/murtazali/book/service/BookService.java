package ru.murtazali.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.murtazali.book.DAO.Impl.BookDAO;
import ru.murtazali.book.model.Book;

import java.util.List;

@Service
public class BookService {
    private BookDAO bookDAO;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return bookDAO.getBooks();
    }

}
