package racingcar.model.race;

import racingcar.model.car.Cars;

public class Race {

    private final Cars cars;
    private final RaceGameCount raceGameCount;
    private final RaceResult result;

    private Race(Cars cars, RaceGameCount raceGameCount) {
        this.cars = cars;
        this.raceGameCount = raceGameCount;
        result = RaceResult.create();
    }

    public static Race of(Cars cars, RaceGameCount raceGameCount) {
        return new Race(cars, raceGameCount);
    }

    public void start() {
        while (!raceGameCount.isGameOver()) {
            raceGameCount.run();
            cars.run();
            result.captureCars(cars);
        }
    }

    public RaceResult getResult() {
        return result;
    }
}
