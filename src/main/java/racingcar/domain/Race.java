package racingcar.domain;

import java.util.List;
import racingcar.response.RaceResultResponse;

public class Race {

    private Cars cars;
    private Try tryCount;

    public Race(Cars cars, Try tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public RaceResultResponse doRace() {
        tryCount.tryRace();
        cars.moveAllCars();
        return cars.toResponse();
    }

    public boolean isOver() {
        return tryCount.isRaceOver();
    }

    public List<String> findWinners(){
        return cars.findWinners();
    }
}
