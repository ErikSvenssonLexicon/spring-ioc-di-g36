package se.lexicon.model.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TodoItem {

    private int id;
    private String topic;
    private String description;
    private BigDecimal payment;
    private boolean done;
    private Person owner;
    private Set<Person> assignees;

    public TodoItem(int id, String topic, String description, BigDecimal payment, boolean done, Person owner) {
        setId(id);
        setTopic(topic);
        setDescription(description);
        setPayment(payment);
        setDone(done);
        setOwner(owner);
    }

    public TodoItem(String topic, String description, BigDecimal payment) {
        this(0, topic, description, payment, false, null);
    }

    public TodoItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Set<Person> getAssignees() {
        if(assignees == null) assignees = new HashSet<>();
        return assignees;
    }

    public void setAssignees(Set<Person> assignees) {
        if(assignees == null) assignees = new HashSet<>();
        if(assignees.isEmpty()){
            if(this.assignees != null){
                for(Person person : this.assignees){
                    person.getTodoItems().remove(this);
                }
            }
        }else {
            for(Person person : assignees){
                person.getTodoItems().add(this);
            }
        }
        this.assignees = assignees;
    }

    public void removeAssignee(Person person) {
        if(person == null) throw new IllegalArgumentException("Person person was null");
        if(assignees == null) assignees = new HashSet<>();
        assignees.remove(person);
        person.getTodoItems().remove(this);
    }

    public void addAssignee(Person person){
        if(person == null) throw new IllegalArgumentException("Person person was null");
        if(assignees == null) assignees = new HashSet<>();
        assignees.add(person);
        person.getTodoItems().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return getId() == todoItem.getId() && isDone() == todoItem.isDone() && Objects.equals(getTopic(), todoItem.getTopic()) && Objects.equals(getDescription(), todoItem.getDescription()) && Objects.equals(getPayment(), todoItem.getPayment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTopic(), getDescription(), getPayment(), isDone());
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", description='" + description + '\'' +
                ", payment=" + payment +
                ", done=" + done +
                '}';
    }
}
