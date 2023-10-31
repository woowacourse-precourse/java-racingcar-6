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

        List<RoundHistory> roundHistories = new ArrayList<>();

        while (!numberOfRound.isLastRound()) {
            cars.moveAllCars(navigator);

            RoundHistory roundHistory = new RoundHistory(
                    numberOfRound,
                    new RoundResult(cars.getCurrentStatus()));

            roundHistories.add(roundHistory);
            numberOfRound.nextRound();
        }

        List<Name> winners = decideWinners(roundHistories);

        return new GameResult(roundHistories, winners);
    }

    private List<Name> decideWinners(List<RoundHistory> roundHistories) {
        RoundHistory lastRoundHistory = roundHistories.get(roundHistories.size() - 1);
        RoundResult lastRoundResult = lastRoundHistory.roundResult();
        return lastRoundResult.getWinners();
    }
}
