package org.fasttrack.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private int id;
    @Column
    private String subject;
    @Column
    private int age;
    @Column
    private String fullName;

    @ManyToMany(mappedBy = "teachers")
    private Set<Kid> kids;

    public Teacher(String subject, int age, String fullName, Set<Kid> kids) {
        this.subject = subject;
        this.age = age;
        this.fullName = fullName;
        this.kids = kids;
    }

    public Teacher(int id, String subject, int age, String fullName, Set<Kid> kids) {
        this.id = id;
        this.subject = subject;
        this.age = age;
        this.fullName = fullName;
        this.kids = kids;
    }

    public Teacher(int id, String subject, int age, String fullName) {
        this.id = id;
        this.subject = subject;
        this.age = age;
        this.fullName = fullName;
    }

    public Teacher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Kid> getKids() {
        return kids;
    }

    public void setKids(Set<Kid> kids) {
        this.kids = kids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (id != teacher.id) return false;
        if (age != teacher.age) return false;
        if (!Objects.equals(subject, teacher.subject)) return false;
        if (!Objects.equals(fullName, teacher.fullName)) return false;
        return Objects.equals(kids, teacher.kids);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (kids != null ? kids.hashCode() : 0);
        return result;
    }
}
