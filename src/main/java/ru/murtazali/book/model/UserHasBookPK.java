package ru.murtazali.book.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
public class UserHasBookPK implements Serializable {
    private int userId;
    private int bookId;
    private int typeId;

    public UserHasBookPK() {
    }

    @Id
    @Column(name = "User_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "Book_id", nullable = false)
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Column(name = "Type_id", nullable = false)
    @Id
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserHasBookPK that = (UserHasBookPK) o;

        if (userId != that.userId) return false;
        if (bookId != that.bookId) return false;
        if (typeId != that.typeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + bookId;
        result = 31 * result + typeId;
        return result;
    }
}
