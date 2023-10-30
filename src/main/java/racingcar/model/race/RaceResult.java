package racingcar.model.race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public List<CarRaceRecords> get() {
        return Collections.unmodifiableList(result);
    }
}
