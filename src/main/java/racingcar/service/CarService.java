package racingcar.service;

import racingcar.dto.CarDto;
import racingcar.entity.Car;
import racingcar.entity.Game;
import racingcar.repository.CarRepository;

import java.util.Arrays;
import java.util.List;

public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car carCreate(String input) {
        Car saveCar = new Car(input);
        return carRepository.save(input);
    }


    public void go(String carName) {
        Car car = carRepository.findByName(carName);
        car.plusScore();
    }

    public void getCartInfo(String carName) {
        Car car = carRepository.findByName(carName);
        car.printStatus();
    }
}
