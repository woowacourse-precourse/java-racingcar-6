package racingcar.domain;

import java.util.List;

public class Race {

    private Cars cars;
    private Try tryCount;

    public Race(Cars cars, Try tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void doRace() {
        tryCount.tryRace();
        cars.moveAllCars();
    }

    public boolean isRaceOver() {
        return tryCount.isRaceOver();
    }

    public List<String> findWinners(){
        return cars.findWinners();
    }
}
