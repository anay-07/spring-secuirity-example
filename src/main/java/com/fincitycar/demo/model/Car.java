package com.fincitycar.demo.model;


import javax.persistence.*;

@Entity(name = "car")
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    protected Long id;

    @Column(name = "name")
    String name;

    @Column(name = "manufacture_name")
    String manufactureName;

    @Column(name = "model")
    String model;

    @Column(name = "manufacturing_year")
    Long manufacturingYear;

    @Column(name = "color")
    String color;


}
