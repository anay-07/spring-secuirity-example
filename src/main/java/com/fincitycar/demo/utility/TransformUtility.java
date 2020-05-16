package com.fincitycar.demo.utility;

import com.fincitycar.demo.DTO.requestDTO.AddCarDTO;
import com.fincitycar.demo.DTO.resonseDTO.CarResponseDTO;
import com.fincitycar.demo.model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class TransformUtility {


    public static final Function<AddCarDTO, Car> carDTOToCar = (carDto) -> {
        Car car = new Car(carDto.getName(), carDto.getManufactureName(), carDto.getModel(), carDto.getManufacturingYear(), carDto.getColor());
        return car;
    };

    public static final Function<Car, CarResponseDTO> carToCarResponseDTO = (car)->{

        CarResponseDTO dto = new CarResponseDTO();
        dto.setId(car.getId());
        dto.setName(car.getName());
        dto.setManufactureName(car.getManufactureName());
        dto.setManufacturingYear(car.getManufacturingYear());
        dto.setColor(car.getColor());
        dto.setModel(car.getModel());

        return dto;
    };

    public static final Function<List<Car>,List<CarResponseDTO>> listOfCarsToListOfCarResponseDTO = (carList)->{

        List<CarResponseDTO> responseDTOS = new ArrayList<>();

        if(carList == null )
            return new ArrayList<>();

        carList.stream().forEach(c->{
            CarResponseDTO dto = new CarResponseDTO();
            dto.setName(c.getName());
            dto.setManufactureName(c.getManufactureName());
            dto.setManufacturingYear(c.getManufacturingYear());
            dto.setColor(c.getColor());
            dto.setModel(c.getModel());
            responseDTOS.add(dto);
        });
        return responseDTOS;
    };

}
