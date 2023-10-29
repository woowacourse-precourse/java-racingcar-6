package racingcar.service;

import racingcar.model.CarsPosition;
import racingcar.model.MovingCount;
import racingcar.model.RacingCars;

public class RaceService {
    private final MovingCount movingCount;
    private final CarsPosition carsPosition;

    private RaceService(MovingCount movingCount, CarsPosition carsPosition) {
        this.movingCount = movingCount;
        this.carsPosition = carsPosition;
    }

    public static RaceService init(RacingCars racingCars, MovingCount movingCount) {
        CarsPosition carsPosition = CarsPosition.createPositionWithRacingCars(racingCars);
        return new RaceService(movingCount, carsPosition);
    }

    public String getRaceResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; movingCount.isNotEqual(i); i++) {
            sb.append(carsPosition.getEachRaceResult());
        }
        return sb.toString();
    }

    public String getWinner() {
        return carsPosition.getWinner();
    }
}
