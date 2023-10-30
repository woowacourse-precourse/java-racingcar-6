package racingcar.model.race;

import java.util.List;

import racingcar.model.car.Cars;

public class CarRaceRecords {

    private final List<CarRaceRecord> carRaceRecords;

    private CarRaceRecords(Cars cars) {
        carRaceRecords = cars.getCars().stream()
                .map(CarRaceRecord::of)
                .toList();
    }

    public static CarRaceRecords from(Cars cars) {
        return new CarRaceRecords(cars);
    }

    public List<CarRaceRecord> getCarRecords() {
        return carRaceRecords;
    }
}
