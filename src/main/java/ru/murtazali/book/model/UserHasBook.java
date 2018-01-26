package ru.murtazali.book.model;

import javax.persistence.*;

@Entity
@Table(name = "User_has_Book", schema = "book")
public class UserHasBook {
    @EmbeddedId
    private UserHasBookPK pk;

    @ManyToOne
    @MapsId("userId")
    private User userByUserId;

    @ManyToOne
    @MapsId("bookId")
    private Book bookByBookId;

    @ManyToOne
    @MapsId("typeId")
    private Type typeByTypeId;

    public UserHasBookPK getPk() {
        return pk;
    }

    public void setPk(UserHasBookPK pk) {
        this.pk = pk;
    }

    public UserHasBook() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserHasBook that = (UserHasBook) o;

        return pk != null ? pk.equals(that.pk) : that.pk == null;
    }

    @Override
    public int hashCode() {
        return pk != null ? pk.hashCode() : 0;
    }

    @ManyToOne
    @JoinColumn(name = "User_id", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
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
    @JoinColumn(name = "Type_id", referencedColumnName = "id", nullable = false)
    public Type getTypeByTypeId() {
        return typeByTypeId;
    }

    public void setTypeByTypeId(Type typeByTypeId) {
        this.typeByTypeId = typeByTypeId;
    }
}
