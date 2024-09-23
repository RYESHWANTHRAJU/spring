package com.example.demo2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="voters")
public class Voter
{
    @Id
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String party;

    public Voter() {
    }

    public Voter(Integer id, String name, Integer age, String gender, String party) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.party = party;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    @Override
    public String toString() {
        return "Voter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", party='" + party + '\'' +
                '}';
    }
}
