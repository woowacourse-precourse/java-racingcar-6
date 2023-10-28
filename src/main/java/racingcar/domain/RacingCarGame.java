package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private final Cars cars;

    public RacingCarGame(List<String> names) {
        this.cars = new Cars(new ArrayList<>(names));
    }

    public void race() {
        cars.race();
    }

    public Cars getCars() {
        return cars;
    }
}
