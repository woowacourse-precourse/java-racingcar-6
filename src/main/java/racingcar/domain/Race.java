package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.RaceResult;

public class Race {
    final List<Car> cars = new ArrayList<>();

    public Race(String carCount) {
    }

    public void moveCars() {}

    public RaceResult findWinners() {
        return null;
    }

    public List<Car> getCars() {
        return cars;
    }
}
