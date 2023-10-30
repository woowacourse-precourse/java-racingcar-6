package racingcar.model;

import racingcar.model.randomnumber.RandomNumber;
import racingcar.util.NameFactory;
import java.util.List;

public class Cars {

    private List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final String names) {
        List<Name> carNames = NameFactory.createNames(names);
        List<Car> cars = carNames.stream()
                .map(Car::createDefault)
                .toList();

        return new Cars(cars);
    }

    public void race(final RandomNumber randomNumber) {
        cars.forEach(car -> {
            int number = randomNumber.pickNumber();
            if (car.isSatisfiedMove(number)) {
                car.move();
            }
        });
    }

    public List<Car> getCars() {
        return cars;
    }
}
