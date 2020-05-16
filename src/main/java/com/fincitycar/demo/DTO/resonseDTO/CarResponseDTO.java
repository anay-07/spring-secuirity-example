package com.fincitycar.demo.DTO.resonseDTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fincitycar.demo.model.Car;
import lombok.Data;

import java.util.List;

@Data
public class CarResponseDTO {


    @JsonProperty("id")
    Long id;

    @JsonProperty("name")
    String name;

    @JsonProperty("manufacture_name")
    String manufactureName;

    @JsonProperty("model")
    String model;

    @JsonProperty("manufacturing_year")
    Long manufacturingYear;

    @JsonProperty("color")
    String color;

}
