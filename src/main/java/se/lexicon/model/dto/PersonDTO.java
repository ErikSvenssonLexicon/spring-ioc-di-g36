package se.lexicon.model.dto;

import java.io.Serializable;
import java.util.List;

public class PersonDTO implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private UserCredentialsDTO userCredentials;
    private List<TodoItemDTOBasic> todoItems;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserCredentialsDTO getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(UserCredentialsDTO userCredentials) {
        this.userCredentials = userCredentials;
    }

    public List<TodoItemDTOBasic> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItemDTOBasic> todoItems) {
        this.todoItems = todoItems;
    }
}
