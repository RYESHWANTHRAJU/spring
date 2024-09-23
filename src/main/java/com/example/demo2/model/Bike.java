package com.example.demo2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bikes")
public class Bike
{
    @Id
    private Integer id;
    private String model;
    private String company;
    private Integer cc;
    private Double mileage;
    private Integer price;

    public Bike(){}
    public Bike(Integer id, String model, String company, Integer cc, Double mileage, Integer price) {
        this.id = id;
        this.model = model;
        this.company = company;
        this.cc = cc;
        this.mileage = mileage;
        this.price = price;
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

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", company='" + company + '\'' +
                ", cc=" + cc +
                ", price=" + price +
                '}';
    }
}
