package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private List<Car> cars;

    private RacingCarGame(List<Car> cars) {
        this.cars = cars;
    }

    public static RacingCarGame from(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(Car.from(name));
        }
        return new RacingCarGame(cars);
    }
}
