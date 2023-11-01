package racingcar.Domain;

import static racingcar.Message.ExceptionMessage.NULL_ERROR;
import static racingcar.Service.CarService.stringToList;

import java.util.List;
import java.util.Objects;

public class RacingCars {
    private final List<Car> cars;

    RacingCars(final String carNames) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingCars that = (RacingCars) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
