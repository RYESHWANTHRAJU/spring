package com.example.demo2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cars")
public class Car
{
    @Id
    private Integer id;
    private String model;
    private String company;
    private String type;

    public Car()
    {

    }

    public Car(Integer id, String model, String company, String type) {
        this.id = id;
        this.model = model;
        this.company = company;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", company='" + company + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
