package racingcar.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import racingcar.IO.IOService;
import racingcar.dto.GameDto;
import racingcar.entity.Car;
import racingcar.repository.CarRepository;

class CarServiceTest {

    @InjectMocks
    CarService carService;
    @Mock
    CarRepository carRepository;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void goTest() {
        Car car = new Car("car");
        when(carRepository.findByName(any())).thenReturn(car);
        carService.go("test");
        verify(carRepository).findByName("test");
    }
    @Test

    public void getCartInfoTest() {
        Car car = new Car("car");
        when(carRepository.findByName(any())).thenReturn(car);
        carService.getCartInfo("test");
        verify(carRepository).findByName("test");
    }

}