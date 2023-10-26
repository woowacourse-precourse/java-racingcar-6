package racingcar.service;

import racingcar.domain.Car;
import racingcar.dto.CarsDto;

public class CarService {

    public CarsDto createCarsByNames(String[] names) {
        Car[] cars = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            cars[i] = new Car(names[i]);
        }

        return new CarsDto(cars);
    }
}
