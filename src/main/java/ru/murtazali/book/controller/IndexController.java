package ru.murtazali.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.murtazali.book.model.Book;
import ru.murtazali.book.service.BookService;

import java.util.List;

@Controller
public class IndexController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String index(ModelMap map){
        map.addAttribute("view_content", "main_view");

        List<Book> bookList = bookService.getAllBooks();
        map.addAttribute("books", bookList);
        return "index";
    }

    @GetMapping("/login")
    public String login(ModelMap map){
        map.addAttribute("view_content", "login_view");

        return "index";
    }
}
