package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> carList = new ArrayList<>();

    public void addCar(final Car car) {
        carList.add(car);
    }
}
