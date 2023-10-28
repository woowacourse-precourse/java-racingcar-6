package racingcar.application;

import racingcar.domain.*;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

    private final Navigator navigator;

    public RacingCarService(Navigator navigator) {
        this.navigator = navigator;
    }

    public GameResult gameStart(final List<String> names, final int tryCount) {
        Cars cars = CarFactory.createCars(names);
        NumberOfRound numberOfRound = new NumberOfRound(tryCount);

        List<RoundHistory> gameHistories = new ArrayList<>();

        for (int i = 0; i < numberOfRound.value(); i++) {
            cars.moveAllCars(navigator);
            RoundHistory roundHistory = new RoundHistory(new NumberOfRound(i + 1), cars.getCurrentStatus());
            gameHistories.add(roundHistory);
        }
        return new GameResult(gameHistories);
    }
}
