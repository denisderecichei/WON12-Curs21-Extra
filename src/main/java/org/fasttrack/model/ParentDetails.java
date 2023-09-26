package org.fasttrack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class ParentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "details_id")
    private int id;
    @Column
    private String email;
    @Column
    private int birthYear;
    @OneToOne
    @JoinColumn(name = "parent_id")
    @JsonIgnore
    private Parent parent;

    public ParentDetails(Parent parent, String email, int birthYear) {
        this.parent = parent;
        this.email = email;
        this.birthYear = birthYear;
    }

    public ParentDetails(Parent parent, int id, String email, int birthYear) {
        this.parent = parent;
        this.id = id;
        this.email = email;
        this.birthYear = birthYear;
    }

    public ParentDetails() {
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
