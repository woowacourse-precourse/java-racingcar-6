package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class Round {
    private final List<Integer> numbers;
    private final Cars cars;

    public Round(List<Integer> numbers, Cars cars) {
        this.numbers = numbers;
        this.cars = cars;
    }

    public void race() {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.findCarByIndex(i);
            car.move(numbers.get(i));
        }
    }
}
