package racingcar.model;

import static java.lang.Integer.parseInt;
import static racingcar.model.CarSplitConstantType.COMMAS;
import static racingcar.model.CarSplitConstantType.SPLIT_LIMIT;

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
