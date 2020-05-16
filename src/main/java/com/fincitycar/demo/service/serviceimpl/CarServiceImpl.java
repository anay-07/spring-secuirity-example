package com.fincitycar.demo.service.serviceimpl;

import com.fincitycar.demo.DTO.requestDTO.AddCarDTO;
import com.fincitycar.demo.DTO.resonseDTO.CarResponseDTO;
import com.fincitycar.demo.enums.SearchType;
import com.fincitycar.demo.exception.CarNotFoundException;
import com.fincitycar.demo.exception.IErrors;
import com.fincitycar.demo.exception.InvalidSearchTypeException;
import com.fincitycar.demo.model.Car;
import com.fincitycar.demo.repository.CarRepository;
import com.fincitycar.demo.service.services.ICarService;
import com.fincitycar.demo.utility.TransformUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements ICarService {


    @Autowired
    CarRepository carRepository;

    @Override
    public CarResponseDTO addCar(AddCarDTO addCarDTO) {

       Car car = TransformUtility.carDTOToCar.apply(addCarDTO);
       car = carRepository.saveAndFlush(car);
       return TransformUtility.carToCarResponseDTO.apply(car);
    }

    @Override
    public CarResponseDTO updateCar(Long carId, AddCarDTO addCarDTO) throws CarNotFoundException {
        Optional<Car> car = carRepository.findById(carId);
        if(!car.isPresent()){
            String develop_msg = String.format("Car not present for id: %s", carId) ;
            throw new CarNotFoundException(IErrors.RESOURCE_NOT_FOUND("Car not present", develop_msg));
        }
        Car updatedCar = updateCar(car.get(), addCarDTO);
        return TransformUtility.carToCarResponseDTO.apply(updatedCar);
    }

    private Car updateCar(Car car,AddCarDTO carDTO){
        car.setName(carDTO.getName());
        car.setManufactureName(carDTO.getManufactureName());
        car.setManufacturingYear(carDTO.getManufacturingYear());
        car.setModel(carDTO.getModel());
        car.setColor(carDTO.getColor());
        return carRepository.saveAndFlush(car);
    }


    @Override
    public boolean removeCar(Long carId) throws CarNotFoundException {
        try{
            carRepository.deleteById(carId);
        }catch(EmptyResultDataAccessException e){
            String develop_msg = String.format("Car not present for id: %s", carId) ;
            throw new CarNotFoundException(IErrors.RESOURCE_NOT_FOUND("Car not present", develop_msg));
        }

        return true;
    }

    @Override
    public List<CarResponseDTO> getAllCars() {
        List<Car> listOfCar = carRepository.findAll();
        return TransformUtility.listOfCarsToListOfCarResponseDTO.apply(listOfCar);
    }

    @Override
    public CarResponseDTO getCarById(Long carId) throws CarNotFoundException {
        Optional<Car> car = carRepository.findById(carId);
        if(!car.isPresent()){
            String develop_msg = String.format("Car not present for id: %s", carId) ;
            throw new CarNotFoundException(IErrors.RESOURCE_NOT_FOUND("Car not present", develop_msg));
        }
        return TransformUtility.carToCarResponseDTO.apply(car.get());
    }

    @Override
    public List<CarResponseDTO> serach(String searchBy, String searchValue) throws InvalidSearchTypeException {

        SearchType searchType = SearchType.valueOf(searchBy);
        if(searchType==null) {
            String develop_msg = String.format("Invalid serachType: %s", searchBy) ;
            throw new InvalidSearchTypeException(IErrors.RESOURCE_NOT_FOUND("Invalid serachType",develop_msg));
        }

        List<Car> searchResults = getSearchResult(searchType,searchValue);
        return TransformUtility.listOfCarsToListOfCarResponseDTO.apply(searchResults);
    }

    private List<Car> getSearchResult(SearchType searchType, String searchValue) {

        List<Car> cars = new ArrayList<>();
        switch (searchType){
            case NAME: cars = carRepository.findByName(searchValue);
                        break;

            case MANUFACTURER_NAME:  cars = carRepository.findByManufactureName(searchValue);
                                    break;

            case MANUFACTURER_YEAR: cars = carRepository.findByManufacturingYear(searchValue);
                                    break;

            case MODEL: cars = carRepository.findByModel(searchValue);
                        break;

            case COLOR: cars = carRepository.findByColor(searchValue);
                        break;

            default: break;
        }

        return cars;
    }
}
