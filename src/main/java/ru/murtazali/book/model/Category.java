package ru.murtazali.book.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Category {
    private int id;
    private String name;
    private String urlCategory;
    private Collection<BookHasCategory> bookHasCategoriesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "URL_category", nullable = false, length = 255)
    public String getUrlCategory() {
        return urlCategory;
    }

    public void setUrlCategory(String urlCategory) {
        this.urlCategory = urlCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        if (urlCategory != null ? !urlCategory.equals(category.urlCategory) : category.urlCategory != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (urlCategory != null ? urlCategory.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<BookHasCategory> getBookHasCategoriesById() {
        return bookHasCategoriesById;
    }

    public void setBookHasCategoriesById(Collection<BookHasCategory> bookHasCategoriesById) {
        this.bookHasCategoriesById = bookHasCategoriesById;
    }
}
