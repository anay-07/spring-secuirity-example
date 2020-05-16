package com.fincitycar.demo.model;


import lombok.Data;

import javax.persistence.*;

@Entity(name = "car")
@Table(name = "car")
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    protected Long id;

    @Column(name = "car_name")
    String name;

    @Column(name = "manufacture_name")
    String manufactureName;

    @Column(name = "model")
    String model;

    @Column(name = "manufacturing_year")
    Long manufacturingYear;

    @Column(name = "color")
    String color;

    public Car(){}

    public Car(String name, String manufactureName, String model, Long manufacturingYear, String color) {
        this.name = name;
        this.manufactureName = manufactureName;
        this.model = model;
        this.manufacturingYear = manufacturingYear;
        this.color = color;
    }
}
