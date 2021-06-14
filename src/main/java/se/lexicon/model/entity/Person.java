package se.lexicon.model.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private UserCredentials userCredentials;
    private Set<TodoItem> todoItems;

    public Person(int id, String firstName, String lastName, String email, UserCredentials userCredentials) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setUserCredentials(userCredentials);
    }

    public Person(String firstName, String lastName, String email) {
        this(0, firstName, lastName, email, null);
    }

    public Person(){}

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
        if(email == null) throw new IllegalArgumentException("Email was null");
        this.email = email;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public Set<TodoItem> getTodoItems() {
        if(todoItems == null) todoItems = new HashSet<>();
        return todoItems;
    }

    public void setTodoItems(Set<TodoItem> todoItems) {
        if(todoItems == null) todoItems = new HashSet<>();
        if(todoItems.isEmpty()){
            if(this.todoItems != null){
                for(TodoItem todoItem : this.todoItems){
                    todoItem.getAssignees().remove(this);
                }
            }
        }else {
            for(TodoItem todoItem : todoItems){
                todoItem.getAssignees().add(this);
            }
        }
        this.todoItems = todoItems;
    }

    public void addTodoItem(TodoItem todoItem){
        if(todoItem == null) throw new IllegalArgumentException("TodoItem todoItem was null");
        if(todoItems == null) todoItems = new HashSet<>();
        todoItems.add(todoItem);
        todoItem.getAssignees().add(this);
    }

    public void removeTodoItem(TodoItem todoItem){
        if(todoItem == null) throw new IllegalArgumentException("TodoItem todoItem was null");
        if(todoItems == null) todoItems = new HashSet<>();
        todoItems.remove(todoItem);
        todoItem.getAssignees().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getId() == person.getId() && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getEmail(), person.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail());
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
