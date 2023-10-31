package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCarsResult {
    private List<CarDto> winners = new ArrayList<>();

    public void add(Car car) {
        this.winners.add(car.toDto());
    }

    public int size() {
        return winners.size();
    }

    @Override
    public String toString() {
        List<String> names = new ArrayList<>();
        for (CarDto car : winners) {
            names.add(car.getName());
        }
        return String.join(",", names);
    }
}
