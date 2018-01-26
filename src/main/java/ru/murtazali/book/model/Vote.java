package ru.murtazali.book.model;

import javax.persistence.*;

@Entity
public class Vote {
    private int id;
    private int rating;
    private Comment commentByCommentId;
    private User userByUserId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "rating", nullable = false)
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vote vote = (Vote) o;

        if (id != vote.id) return false;
        if (rating != vote.rating) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + rating;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Comment_id", referencedColumnName = "id", nullable = false)
    public Comment getCommentByCommentId() {
        return commentByCommentId;
    }

    public void setCommentByCommentId(Comment commentByCommentId) {
        this.commentByCommentId = commentByCommentId;
    }

    @ManyToOne
    @JoinColumn(name = "User_id", referencedColumnName = "id", nullable = false)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }
}
