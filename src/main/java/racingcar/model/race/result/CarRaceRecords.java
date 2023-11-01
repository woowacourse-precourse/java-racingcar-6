package racingcar.model.race.result;

import java.util.List;
import java.util.stream.Stream;

import racingcar.model.car.Cars;

public class CarRaceRecords {

    private final List<CarRaceRecord> carRaceRecords;

    private CarRaceRecords(final Cars cars) {
        carRaceRecords = cars.stream()
                .map(CarRaceRecord::of)
                .toList();
    }

    public static CarRaceRecords from(final Cars cars) {
        return new CarRaceRecords(cars);
    }

    public Stream<CarRaceRecord> stream() {
        return carRaceRecords.stream();
    }
}
