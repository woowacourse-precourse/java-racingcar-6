package racingcar.service;

import racingcar.domain.Car;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnerDto;

import java.util.ArrayList;
import java.util.Arrays;

public class RaceGameService {

    public void roundStart(CarsDto carsDto) {
        Car[] cars = carsDto.cars();

        for (Car car : cars) {
            car.randomDrive();
        }

    }

    public WinnerDto findWinner(CarsDto carsDto) {
        int[] locates = carsDto.carLocates();
        int highestLocation = Arrays.stream(locates)
                .max()
                .orElse(0);

        if (highestLocation == 0) {
            return new WinnerDto(carsDto.ownerNames());
        }

        Car[] finalCars = carsDto.cars();
        ArrayList<String> winners = new ArrayList<>();
        for (Car car : finalCars) {
            if (car.getLocation() == highestLocation) {
                winners.add(car.ownerOfCar());
            }
        }
        return new WinnerDto(winners.toArray(new String[0]));
    }
}
