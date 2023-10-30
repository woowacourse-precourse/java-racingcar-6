package racingcar.Domain;

import static racingcar.Service.CarService.stringToList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private List<Car> cars;

    private RacingCars(final String carNames) {
        this.cars = stringToList(carNames);
    }

    public static RacingCars create(final String carNames) {
        return new RacingCars(carNames);
    }

    public void race() {
        for (Car car : cars) {
            car.CarMove();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getCarCount() {
        return cars.size();
    }

}
