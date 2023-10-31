package racingcar.model;

import static racingcar.model.exception.ExceptionMessage.DUPLICATE_CAR_EXCEPTION;

import racingcar.model.randomnumber.RandomNumber;
import racingcar.util.NameFactory;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final String names) {
        List<Name> carNames = NameFactory.createNames(names);
        List<Car> cars = carNames.stream()
                .map(Car::createDefault)
                .distinct()
                .toList();

        validate(carNames, cars);
        return new Cars(cars);
    }

    private static void validate(final List<Name> carNames, final List<Car> cars) {
        if (carNames.size() != cars.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_EXCEPTION.getMessage());
        }
    }

    public void race(final RandomNumber randomNumber) {
        cars.forEach(car -> {
            int number = randomNumber.pickNumber();
            car.move(number);
        });
    }

    public int calculateWinnersPosition() {
        int position = 0;
        for (Car car : cars) {
            position = Math.max(position, car.getPosition());
        }
        return position;
    }

    public List<Car> getCars() {
        return cars;
    }
}
