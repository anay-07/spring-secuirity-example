package com.fincitycar.demo.repository;

import com.fincitycar.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,Long> {

    @Query("select c from car c where name like %?1%")
    public List<Car> findByName(String name);

    @Query("select c from car c where manufacture_name like %?1%")
    public List<Car> findByManufactureName(String manufactureName);

    @Query("select c from car c where manufacturing_year like %?1%")
    public List<Car> findByManufacturingYear(String manufacturingYear);

    @Query("select c from car c where model like %?1%")
    public List<Car> findByModel(String model);

    @Query("select c from car c where color like %?1%")
    public List<Car> findByColor(String color);


}
