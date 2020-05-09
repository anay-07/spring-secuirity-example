package com.fincitycar.demo.controller;


import com.fincitycar.demo.DTO.requestDTO.AddCarDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/")
public class CarController {


    @PostMapping(value = "cars", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<Object> addCar(@Valid @RequestBody AddCarDTO addCarDTO){


        return new ResponseEntity<>(addCarDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "cars", produces = {"application/json"})
    public ResponseEntity<Object> getAllCars(){


        return new ResponseEntity<>(new AddCarDTO(), HttpStatus.CREATED);
    }

    @GetMapping(value = "cars/{carId}", produces = {"application/json"})
    public ResponseEntity<Object> getCarById(@PathVariable(value = "carId") Long carId){


        return new ResponseEntity<>(new AddCarDTO(), HttpStatus.CREATED);
    }

    @PostMapping(value = "cars/{carId}", consumes = {"application/json"},produces = {"application/json"})
    public ResponseEntity<Object> updateCar(@PathVariable(value = "carId") Long carId, @Valid @RequestBody AddCarDTO addCarDTO){

        return new ResponseEntity<>(addCarDTO,HttpStatus.OK);
    }

    @DeleteMapping(value = "cars/{carId}",produces = {"application/json"})
    public ResponseEntity<Object> removeCar(@PathVariable(value = "carId") Long carId){

        return new ResponseEntity<>(new AddCarDTO(),HttpStatus.OK);
    }




}
