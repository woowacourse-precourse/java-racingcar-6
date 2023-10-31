package racingcar.Domain;

import static racingcar.Message.ExceptionMessage.NULL_ERROR;
import static racingcar.Service.CarService.stringToList;

import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    private RacingCars(final String carNames) {
        this.cars = stringToList(carNames);
    }

    public static RacingCars create(final String carNames) {
        if (carNames == null) {
            throw new IllegalArgumentException(NULL_ERROR);
        }
        return new RacingCars(carNames);
    }

    public void race() {
        for (Car car : cars) {
            int num = RaceNumberGenerator.generateRandomNumber();
            car.CarMove(num);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

}
