package ru.murtazali.book.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Type {
    private int id;
    private String name;
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
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Type type = (Type) o;

        if (id != type.id) return false;
        if (name != null ? !name.equals(type.name) : type.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "typeByTypeId")
    public Collection<UserHasBook> getUserHasBooksById() {
        return userHasBooksById;
    }

    public void setUserHasBooksById(Collection<UserHasBook> userHasBooksById) {
        this.userHasBooksById = userHasBooksById;
    }
}
