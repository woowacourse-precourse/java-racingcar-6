package racingcar.service;

import racingcar.domain.Car;
import racingcar.dto.CarsDto;

public class RaceGameService {

    public int[] roundStart(CarsDto carsDto) {
        Car[] cars = carsDto.cars();
        int[] locates = new int[cars.length];

        for (int idx=0; idx<cars.length; idx++) {
            locates[idx] = cars[idx].randomDrive();
        }

        return locates;
    }
}
