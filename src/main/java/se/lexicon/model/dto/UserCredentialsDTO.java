package se.lexicon.model.dto;

import java.io.Serializable;

public class UserCredentialsDTO implements Serializable {
    private int id;
    private String username;
    private String role;
    private PersonDTOBasic personData;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public PersonDTOBasic getPersonData() {
        return personData;
    }

    public void setPersonData(PersonDTOBasic personData) {
        this.personData = personData;
    }
}
