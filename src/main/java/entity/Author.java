package entity;

import javax.persistence.*;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String nick;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", nick='" + nick + '\'' +
                '}';
    }
}
