package ru.murtazali.book.model;

import javax.persistence.*;

@Entity
@Table(name = "Book_has_Author", schema = "book")
public class BookHasAuthor {
    @EmbeddedId
    private BookHasAuthorPK pk;

    @ManyToOne
    @MapsId("bookId")
    private Book bookByBookId;
    @ManyToOne
    @MapsId("authorId")
    private Author authorByAuthorId;

    public BookHasAuthorPK getPk() {
        return pk;
    }

    public void setPk(BookHasAuthorPK pk) {
        this.pk = pk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookHasAuthor that = (BookHasAuthor) o;

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
    @JoinColumn(name = "Author_id", referencedColumnName = "id", nullable = false)
    public Author getAuthorByAuthorId() {
        return authorByAuthorId;
    }

    public void setAuthorByAuthorId(Author authorByAuthorId) {
        this.authorByAuthorId = authorByAuthorId;
    }
}
