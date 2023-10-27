package racingcar.service;

import java.util.Arrays;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.vo.CarName;

public class CarFactoryService {


    CarRepository carRepository = CarRepository.getInstance();

    public void createCars(String[] cars) {
        Arrays.asList(cars).forEach(this::createCar);
    }

    public void createCar(String carName) {
        CarName name = new CarName(carName);
        Car car = new Car(name);

        this.carRepository.save(car);

    }
}
