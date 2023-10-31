package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.CarsPosition;
import racingcar.model.MovingCount;
import racingcar.model.RacingCars;
import racingcar.dto.RaceResultTexts;

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

    public RaceResultTexts getTotalResult() {
        List<String> totalResult = new ArrayList<>();
        for (int i = 0; movingCount.isNotEqual(i); i++) {
            carsPosition.race();
            RaceResultTexts eachRaceResult = carsPosition.getEachRaceResult();
            totalResult.add(eachRaceResult.convertOneLine());
        }
        return new RaceResultTexts(totalResult);
    }

    public String getWinner() {
        return carsPosition.getWinner();
    }
}
