package racingcar;

import domain.*;
import ui.Output;

import java.util.List;

public class RacingGame {
    RandomNumberStrategy moveStrategy;

    public RacingGame(RandomNumberStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public Cars generateCars(String carNames) {
        return new Cars(carNames);
    }

    public RaceResult startRace(String inputNumber, Cars cars) {
        AttemptNumber attemptNumber = new AttemptNumber(inputNumber);
        RaceResult raceResult = new RaceResult();
        int i = 0;
        for (i = 0; i < attemptNumber.getAttemptNumber(); i++) {
            final List<Car> raceCars = cars.moveCars(moveStrategy);
            raceResult.add(new RaceStatus(raceCars));
        }

        return raceResult;
    }
}
