package racingcar.model;

import java.util.Collections;
import java.util.List;

public record RacingGame(List<Car> cars, int round) {

    @Override
    public List<Car> cars() {
        return Collections.unmodifiableList(cars);
    }

    public void proceedRound() {
        cars.forEach(Car::move);
    }
}
