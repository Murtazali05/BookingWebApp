package ru.murtazali.book.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Author {
    private int id;
    private String fio;
    private String about;
    private String pic;
    private Collection<BookHasAuthor> bookHasAuthorsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "FIO", nullable = false, length = 255)
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Basic
    @Column(name = "about", nullable = false, length = -1)
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Basic
    @Column(name = "pic", nullable = false, length = 45)
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (id != author.id) return false;
        if (fio != null ? !fio.equals(author.fio) : author.fio != null) return false;
        if (about != null ? !about.equals(author.about) : author.about != null) return false;
        if (pic != null ? !pic.equals(author.pic) : author.pic != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (about != null ? about.hashCode() : 0);
        result = 31 * result + (pic != null ? pic.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "authorByAuthorId")
    public Collection<BookHasAuthor> getBookHasAuthorsById() {
        return bookHasAuthorsById;
    }

    public void setBookHasAuthorsById(Collection<BookHasAuthor> bookHasAuthorsById) {
        this.bookHasAuthorsById = bookHasAuthorsById;
    }
}
