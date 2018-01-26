package ru.murtazali.book.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.murtazali.book.model.Category;

public interface CategoryDAO extends JpaRepository<Category, Integer> {

}

