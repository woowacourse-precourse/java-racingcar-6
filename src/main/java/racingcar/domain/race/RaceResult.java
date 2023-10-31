package racingcar.domain.race;

import racingcar.domain.car.Car;

import java.util.List;
import java.util.StringJoiner;

public record RaceResult(
        List<Car> winners
) {
    public String getWinnerNames() {
        StringJoiner sj = new StringJoiner(", ");

        for (Car car : winners) {
            sj.add(car.getName());
        }

        return sj.toString();
    }
}
