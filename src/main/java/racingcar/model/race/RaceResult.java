package racingcar.model.race;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import racingcar.model.car.Cars;

public class RaceResult {

    private final List<CarRaceRecords> result = new ArrayList<>();

    private RaceResult() {
    }

    public static RaceResult create() {
        return new RaceResult();
    }

    void captureCars(Cars cars) {
        result.add(CarRaceRecords.from(cars));
    }

    public Stream<CarRaceRecords> stream() {
        return result.stream();
    }
}
