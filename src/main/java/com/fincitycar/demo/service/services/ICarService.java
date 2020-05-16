package com.fincitycar.demo.service.services;

import com.fincitycar.demo.DTO.requestDTO.AddCarDTO;
import com.fincitycar.demo.DTO.resonseDTO.CarResponseDTO;
import com.fincitycar.demo.exception.CarNotFoundException;
import com.fincitycar.demo.exception.InvalidSearchTypeException;
import com.fincitycar.demo.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ICarService {

    public CarResponseDTO addCar(AddCarDTO addCarDTO);
    public CarResponseDTO updateCar(Long id, AddCarDTO addCarDTO) throws CarNotFoundException;
    public boolean removeCar(Long carId) throws CarNotFoundException;
    public List<CarResponseDTO> getAllCars();
    public CarResponseDTO getCarById(Long carId) throws CarNotFoundException;
    public List<CarResponseDTO> serach(String searchBy, String searchValue) throws InvalidSearchTypeException;

}
