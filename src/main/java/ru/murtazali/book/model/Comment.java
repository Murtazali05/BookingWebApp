package ru.murtazali.book.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Comment {
    private int id;
    private String title;
    private String content;
    private Timestamp mydate;
    private int countLike;
    private int countDislike;
    private User userByUsersId;
    private Book bookByBooksId;
    private Collection<Vote> votesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content", nullable = false, length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "mydate", nullable = false)
    public Timestamp getMydate() {
        return mydate;
    }

    public void setMydate(Timestamp mydate) {
        this.mydate = mydate;
    }

    @Basic
    @Column(name = "count_like", nullable = false)
    public int getCountLike() {
        return countLike;
    }

    public void setCountLike(int countLike) {
        this.countLike = countLike;
    }

    @Basic
    @Column(name = "count_dislike", nullable = false)
    public int getCountDislike() {
        return countDislike;
    }

    public void setCountDislike(int countDislike) {
        this.countDislike = countDislike;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != comment.id) return false;
        if (countLike != comment.countLike) return false;
        if (countDislike != comment.countDislike) return false;
        if (title != null ? !title.equals(comment.title) : comment.title != null) return false;
        if (content != null ? !content.equals(comment.content) : comment.content != null) return false;
        if (mydate != null ? !mydate.equals(comment.mydate) : comment.mydate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (mydate != null ? mydate.hashCode() : 0);
        result = 31 * result + countLike;
        result = 31 * result + countDislike;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false)
    public User getUserByUsersId() {
        return userByUsersId;
    }

    public void setUserByUsersId(User userByUsersId) {
        this.userByUsersId = userByUsersId;
    }

    @ManyToOne
    @JoinColumn(name = "books_id", referencedColumnName = "id", nullable = false)
    public Book getBookByBooksId() {
        return bookByBooksId;
    }

    public void setBookByBooksId(Book bookByBooksId) {
        this.bookByBooksId = bookByBooksId;
    }

    @OneToMany(mappedBy = "commentByCommentId")
    public Collection<Vote> getVotesById() {
        return votesById;
    }

    public void setVotesById(Collection<Vote> votesById) {
        this.votesById = votesById;
    }
}
