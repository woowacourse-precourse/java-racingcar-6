package racingcar.model.race.result;

import racingcar.model.car.Car;
import racingcar.model.car.CarName;

public record CarRaceRecord(CarName carName, int distance) {
    public static CarRaceRecord of(final Car car) {
        return new CarRaceRecord(car.getCarName(), car.getDistance());
    }
}
