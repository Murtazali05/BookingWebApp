package ru.murtazali.book.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class User {
    private int id;
    private String login;
    private String email;
    private String password;
    private String name;
    private Date birthday;
    private String linkAvatarka;
    private Collection<Comment> commentsById;
    private Role roleByRolesId;
    private Collection<UserHasBook> userHasBooksById;
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
    @Column(name = "login", nullable = false, length = 16)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "birthday", nullable = false)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "link_avatarka", nullable = true, length = 45)
    public String getLinkAvatarka() {
        return linkAvatarka;
    }

    public void setLinkAvatarka(String linkAvatarka) {
        this.linkAvatarka = linkAvatarka;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (birthday != null ? !birthday.equals(user.birthday) : user.birthday != null) return false;
        if (linkAvatarka != null ? !linkAvatarka.equals(user.linkAvatarka) : user.linkAvatarka != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (linkAvatarka != null ? linkAvatarka.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUsersId")
    public Collection<Comment> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<Comment> commentsById) {
        this.commentsById = commentsById;
    }

    @ManyToOne
    @JoinColumn(name = "roles_id", referencedColumnName = "id", nullable = false)
    public Role getRoleByRolesId() {
        return roleByRolesId;
    }

    public void setRoleByRolesId(Role roleByRolesId) {
        this.roleByRolesId = roleByRolesId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<UserHasBook> getUserHasBooksById() {
        return userHasBooksById;
    }

    public void setUserHasBooksById(Collection<UserHasBook> userHasBooksById) {
        this.userHasBooksById = userHasBooksById;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<Vote> getVotesById() {
        return votesById;
    }

    public void setVotesById(Collection<Vote> votesById) {
        this.votesById = votesById;
    }
}
