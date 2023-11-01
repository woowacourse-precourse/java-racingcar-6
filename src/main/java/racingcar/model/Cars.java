package racingcar.model;

import racingcar.model.randomnumber.RandomNumber;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final String input) {
        List<Name> carNames = Names.from(input)
                .getNames();
        List<Car> cars = carNames.stream()
                .map(Car::createDefault)
                .toList();

        return new Cars(cars);
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
