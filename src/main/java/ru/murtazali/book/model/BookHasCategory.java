package ru.murtazali.book.model;

import javax.persistence.*;

@Entity
@Table(name = "Book_has_Category", schema = "book")
public class BookHasCategory {
    @EmbeddedId
    private BookHasCategoryPK pk;

    @ManyToOne
    @MapsId("bookId")
    private Book bookByBookId;

    @ManyToOne
    @MapsId("categoryId")
    private Category categoryByCategoryId;

    public BookHasCategoryPK getPk() {
        return pk;
    }

    public void setPk(BookHasCategoryPK pk) {
        this.pk = pk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookHasCategory that = (BookHasCategory) o;

        return pk != null ? pk.equals(that.pk) : that.pk == null;
    }

    @Override
    public int hashCode() {
        return pk != null ? pk.hashCode() : 0;
    }

    @ManyToOne
    @JoinColumn(name = "Book_id", referencedColumnName = "id", nullable = false)
    public Book getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(Book bookByBookId) {
        this.bookByBookId = bookByBookId;
    }

    @ManyToOne
    @JoinColumn(name = "Category_id", referencedColumnName = "id", nullable = false)
    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
