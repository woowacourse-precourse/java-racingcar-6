package racingcar.domain;

import racingcar.domain.wrapper.RaceRound;

public class Race {
    private final Cars cars;
    private final RaceRound raceRound;

    private Race(Cars cars, RaceRound raceRound) {
        this.cars = cars;
        this.raceRound = raceRound;
    }

    public static Race create(Cars cars, RaceRound raceRound) {
        return new Race(cars, raceRound);
    }

    public Cars getCars() {
        return cars;
    }

    public RaceRound getRaceRound() {
        return raceRound;
    }

    public void roundStart() {
        for (Car car : cars.getCars()) {
            car.tryMove();
        }
    }
}
