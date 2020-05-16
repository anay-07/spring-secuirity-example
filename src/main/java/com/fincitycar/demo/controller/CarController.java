package com.fincitycar.demo.controller;


import com.fincitycar.demo.DTO.requestDTO.AddCarDTO;
import com.fincitycar.demo.DTO.resonseDTO.CarResponseDTO;
import com.fincitycar.demo.enums.ResponseStatus;
import com.fincitycar.demo.exception.CarNotFoundException;
import com.fincitycar.demo.exception.InvalidSearchTypeException;
import com.fincitycar.demo.message.GenericResponse;
import com.fincitycar.demo.service.services.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class CarController {

    @Autowired
    ICarService carService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping(value = "cars", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<Object> addCar(@Valid @RequestBody AddCarDTO addCarDTO){
        CarResponseDTO dto = carService.addCar(addCarDTO);

        GenericResponse<CarResponseDTO> response = new GenericResponse<CarResponseDTO>(ResponseStatus.SUCCESS,new ArrayList(),dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "cars", produces = {"application/json"})
    public ResponseEntity<Object> getAllCars(){
        List<CarResponseDTO> dtos = carService.getAllCars();
        GenericResponse<List<CarResponseDTO>> response = new GenericResponse<List<CarResponseDTO>>(ResponseStatus.SUCCESS,new ArrayList(),dtos);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "cars/{carId}", produces = {"application/json"})
    public ResponseEntity<Object> getCarById(@PathVariable(value = "carId") Long carId) throws CarNotFoundException {
        try{
            CarResponseDTO dto = carService.getCarById(carId);
            GenericResponse<CarResponseDTO> response = new GenericResponse<CarResponseDTO>(ResponseStatus.SUCCESS,new ArrayList(),dto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (CarNotFoundException e){
            throw new CarNotFoundException(e.getError(), e);
        }

    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping(value = "cars/{carId}", consumes = {"application/json"},produces = {"application/json"})
    public ResponseEntity<Object> updateCar(@PathVariable(value = "carId") Long carId, @Valid @RequestBody AddCarDTO addCarDTO) throws CarNotFoundException {
        try{
            CarResponseDTO dto = carService.updateCar(carId, addCarDTO);
            GenericResponse<CarResponseDTO> response = new GenericResponse<CarResponseDTO>(ResponseStatus.SUCCESS,new ArrayList(),dto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (CarNotFoundException e){
            throw new CarNotFoundException(e.getError(), e);
        }

    }

    @PreAuthorize("hasRole('USER')")
    @DeleteMapping(value = "cars/{carId}",produces = {"application/json"})
    public ResponseEntity<Object> removeCar(@PathVariable(value = "carId") Long carId) throws CarNotFoundException {
        try{
            Boolean isDeleted = carService.removeCar(carId);
            GenericResponse<String> response = new GenericResponse<String>(ResponseStatus.SUCCESS,new ArrayList(),"Sucessfully removed car");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }catch (CarNotFoundException e){
            throw new CarNotFoundException(e.getError(), e);
        }

    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "cars/search",produces = {"application/json"})
    public ResponseEntity<Object> search(@RequestParam String searchBy,@RequestParam String searchValue) throws InvalidSearchTypeException {
        try{
            List<CarResponseDTO> dtos = carService.serach(searchBy,searchValue);
            GenericResponse<List<CarResponseDTO>> response = new GenericResponse<List<CarResponseDTO>>(ResponseStatus.SUCCESS,new ArrayList(),dtos);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (InvalidSearchTypeException e) {
            throw new InvalidSearchTypeException(e.getError(), e);
        }
    }




}
