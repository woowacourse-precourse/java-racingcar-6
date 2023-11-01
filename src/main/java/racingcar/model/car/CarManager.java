package racingcar.model.car;

import static java.lang.Integer.parseInt;
import static racingcar.model.car.CarSplitConstants.COMMAS;
import static racingcar.model.car.CarSplitConstants.SPLIT_LIMIT;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import racingcar.utils.validator.CarManagerValidator;
import racingcar.utils.validator.Validator;

public class CarManager {

    private final List<Car> cars;

    public CarManager(final String cars) {
        this(cars, new CarManagerValidator());
    }

    public CarManager(final String cars, final Validator<String> validator) {
        validator.validate(cars);
        this.cars = this.createCarNameListFromString(cars);
    }

    public CarManager(final List<Car> cars) {
        this.cars = cars;
    }


    private List<Car> createCarNameListFromString(final String cars) {
        return Arrays.stream(cars.split(COMMAS.getConstants(), parseInt(SPLIT_LIMIT.getConstants())))
                .map(String::strip)
                .map(RacingCar::new)
                .map(car -> (Car) car)
                .toList();
    }

    public List<Car> move(final Movable strategy) {
        this.cars.forEach(car ->
                car.move(strategy.isMove()));

        return this.getCars();
    }

    public List<Car> getWinner() {
        return this.cars.stream()
                .filter(car -> car.getProgress() == this.getHighestProgress())
                .toList();
    }

    private int getHighestProgress() {
        return this.cars.stream()
                .mapToInt(Car::getProgress)
                .max()
                .orElseThrow(IllegalAccessError::new);
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarManager that = (CarManager) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public String toString() {
        return "CarManager{" +
                "cars=" + cars +
                '}';
    }
}
