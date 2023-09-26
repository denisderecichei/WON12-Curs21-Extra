package org.fasttrack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "Kid")
@Table(name = "kid")
public class Kid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "kid_id")
    private int id;
    @Column
    private String name;
    @Column
    private int age;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "parent_id")
    private Parent parent;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "teacher_kid",
            joinColumns = @JoinColumn(name = "kid_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private Set<Teacher> teachers;

    public Kid() {
    }

    public Kid(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Kid(String name, int age, Parent parent) {
        this.name = name;
        this.age = age;
        this.parent = parent;
    }

    public Kid(String name, int age, Parent parent, Set<Teacher> teachers) {
        this.name = name;
        this.age = age;
        this.parent = parent;
        this.teachers = teachers;
    }

    public Kid(int id, String name, int age, Parent parent, Set<Teacher> teachers) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.parent = parent;
        this.teachers = teachers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
