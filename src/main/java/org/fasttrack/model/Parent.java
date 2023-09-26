package org.fasttrack.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id")
    private int parentId;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private double wage;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "parent")
    private List<Kid> kids;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "details_id")
    private ParentDetails parentDetails;

    public Parent(String name, int age, double wage, List<Kid> kids) {
        this.name = name;
        this.age = age;
        this.wage = wage;
        this.kids = kids;
    }

    public Parent(int parentId, String name, int age, double wage, List<Kid> kids, ParentDetails parentDetails) {
        this.parentId = parentId;
        this.name = name;
        this.age = age;
        this.wage = wage;
        this.kids = kids;
        this.parentDetails = parentDetails;
    }

    public Parent() {
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public List<Kid> getKids() {
        return kids;
    }

    public void setKids(List<Kid> kids) {
        this.kids = kids;
    }

    public ParentDetails getParentDetails() {
        return parentDetails;
    }

    public void setParentDetails(ParentDetails parentDetails) {
        this.parentDetails = parentDetails;
    }
}
