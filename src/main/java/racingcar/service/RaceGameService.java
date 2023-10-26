package racingcar.service;

import racingcar.domain.Car;
import racingcar.dto.CarsDto;

public class RaceGameService {

    public CarsDto roundStart(CarsDto carsDto) {
        Car[] cars = carsDto.cars();

        for (int idx=0; idx<cars.length; idx++) {
            cars[idx].randomDrive();
        }

        return new CarsDto(cars);
    }
}
