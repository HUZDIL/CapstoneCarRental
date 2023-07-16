package com.lecture.capstonecarrental.repositories;

import com.lecture.capstonecarrental.domain.Car;
import com.lecture.capstonecarrental.dto.CarDTO;
import com.lecture.capstonecarrental.exception.ResourceNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("SELECT new com.lecture.capstonecarrental.dto.CarDTO(c) FROM Car c")
    List<CarDTO> findAllCar();

    Optional<CarDTO> findByIdOrderById(Long id) throws ResourceNotFoundException;
}
