package se.lexicon.model.entity;

import java.util.Objects;

public class UserCredentials {
    private int id;
    private String username;
    private String password;
    private ApplicationRole role;
    private Person personData;

    public UserCredentials(int id, String username, String password, ApplicationRole role, Person personData) {
        setId(id);
        setUsername(username);
        setPassword(password);
        setRole(role);
        setPersonData(personData);
    }

    public UserCredentials(String username, String password, ApplicationRole role) {
        this(0, username, password, role, null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ApplicationRole getRole() {
        return role;
    }

    public void setRole(ApplicationRole role) {
        this.role = role;
    }

    public Person getPersonData() {
        return personData;
    }

    public void setPersonData(Person personData) {
        this.personData = personData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCredentials that = (UserCredentials) o;
        return getId() == that.getId() && Objects.equals(getUsername(), that.getUsername()) && getRole() == that.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getRole());
    }

    @Override
    public String toString() {
        return "UserCredentials{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role=" + role +
                '}';
    }
}
