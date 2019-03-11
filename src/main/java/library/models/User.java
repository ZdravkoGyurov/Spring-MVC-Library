package library.models;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Long id;
    private String username;
    private String passwordHash;
    private String fullName;
    private Set<Article> posts = new HashSet<>();

    public void setId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(final String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public Set<Article> getPosts() {
        return posts;
    }
    public void setPosts(final Set<Article> posts) {
        this.posts = posts;
    }

    public User() {};

    public User(final Long id, final String username, final String fullName) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
