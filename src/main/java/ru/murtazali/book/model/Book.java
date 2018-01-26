package ru.murtazali.book.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Book {
    private int id;
    private String title;
    private String description;
    private int pubyear;
    private String pic;
    private String link;
    private String linkShop;
    private Collection<BookHasAuthor> bookHasAuthorsById;
    private Collection<BookHasCategory> bookHasCategoriesById;
    private Collection<Comment> commentsById;
    private Collection<UserHasBook> userHasBooksById;

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
    @Column(name = "description", nullable = false, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "pubyear", nullable = false)
    public int getPubyear() {
        return pubyear;
    }

    public void setPubyear(int pubyear) {
        this.pubyear = pubyear;
    }

    @Basic
    @Column(name = "pic", nullable = false, length = 45)
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Basic
    @Column(name = "link", nullable = false, length = 45)
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Basic
    @Column(name = "link_shop", nullable = false, length = 45)
    public String getLinkShop() {
        return linkShop;
    }

    public void setLinkShop(String linkShop) {
        this.linkShop = linkShop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (pubyear != book.pubyear) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (description != null ? !description.equals(book.description) : book.description != null) return false;
        if (pic != null ? !pic.equals(book.pic) : book.pic != null) return false;
        if (link != null ? !link.equals(book.link) : book.link != null) return false;
        if (linkShop != null ? !linkShop.equals(book.linkShop) : book.linkShop != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + pubyear;
        result = 31 * result + (pic != null ? pic.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (linkShop != null ? linkShop.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Collection<BookHasAuthor> getBookHasAuthorsById() {
        return bookHasAuthorsById;
    }

    public void setBookHasAuthorsById(Collection<BookHasAuthor> bookHasAuthorsById) {
        this.bookHasAuthorsById = bookHasAuthorsById;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Collection<BookHasCategory> getBookHasCategoriesById() {
        return bookHasCategoriesById;
    }

    public void setBookHasCategoriesById(Collection<BookHasCategory> bookHasCategoriesById) {
        this.bookHasCategoriesById = bookHasCategoriesById;
    }

    @OneToMany(mappedBy = "bookByBooksId")
    public Collection<Comment> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<Comment> commentsById) {
        this.commentsById = commentsById;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Collection<UserHasBook> getUserHasBooksById() {
        return userHasBooksById;
    }

    public void setUserHasBooksById(Collection<UserHasBook> userHasBooksById) {
        this.userHasBooksById = userHasBooksById;
    }
}
