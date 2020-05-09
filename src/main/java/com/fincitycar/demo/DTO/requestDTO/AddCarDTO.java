package com.fincitycar.demo.DTO.requestDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
public class AddCarDTO {

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
