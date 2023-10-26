package racingcar.controller;

import racingcar.domain.Car;
import racingcar.dto.CarsDto;

import java.util.Arrays;

public class CarController {

    public CarsDto generateCars(String readStr) {
        String[] strings = readStr.split(",");
        strings = Arrays.stream(strings)
                .map(String::trim)
                .toArray(String[]::new);


        for (String str : strings) {
            if (str.length() > 5 || str.length() < 1) {
                throw new IllegalArgumentException();
            }
        }

        Car[] cars = Arrays.stream(strings)
                .map((name) ->
                        new Car(name))
                .toArray(Car[]::new);

        return new CarsDto(cars);
    }
}
