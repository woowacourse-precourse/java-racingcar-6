package racingcar.model.race;

import java.util.List;
import java.util.stream.Stream;

import racingcar.model.car.Cars;

public class CarRaceRecords {

    private final List<CarRaceRecord> carRaceRecords;

    private CarRaceRecords(Cars cars) {
        carRaceRecords = cars.stream()
                .map(CarRaceRecord::of)
                .toList();
    }

    public static CarRaceRecords from(Cars cars) {
        return new CarRaceRecords(cars);
    }

    public Stream<CarRaceRecord> stream() {
        return carRaceRecords.stream();
    }
}
