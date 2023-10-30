package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> cars;
    private int currentRacingRound;

    public RacingCars(CarsDto carsDto) {
        cars = new ArrayList<>(carsDto.getNumberOfCars());

        for (int i = 0; i < carsDto.getNumberOfCars(); i++) {
            String singleCarName = carsDto.getSingleCarName(i);
            cars.add(Car.createCar(singleCarName));
        }
    }
}
