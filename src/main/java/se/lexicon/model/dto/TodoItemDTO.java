package se.lexicon.model.dto;

import se.lexicon.model.entity.Person;

import java.math.BigDecimal;
import java.util.List;

public class TodoItemDTO {
    private int id;
    private String topic;
    private String description;
    private BigDecimal payment;
    private boolean done;
    private PersonDTOBasic owner;
    private List<PersonDTOBasic> assignees;

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

    public PersonDTOBasic getOwner() {
        return owner;
    }

    public void setOwner(PersonDTOBasic owner) {
        this.owner = owner;
    }

    public List<PersonDTOBasic> getAssignees() {
        return assignees;
    }

    public void setAssignees(List<PersonDTOBasic> assignees) {
        this.assignees = assignees;
    }
}
