package com.fincitycar.demo.service.services;

import com.fincitycar.demo.DTO.requestDTO.AddCarDTO;
import com.fincitycar.demo.model.Car;
import org.springframework.stereotype.Service;

@Service
public interface ICarService {

    public void addCar(AddCarDTO addCarDTO);
    public Car updateCar(Long id, AddCarDTO addCarDTO);
    public boolean removeCar(Long id);

}
