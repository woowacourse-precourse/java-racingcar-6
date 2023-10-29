package racingcar.controller;

import racingcar.common.factory.DTOFactory;
import racingcar.common.strategy.MoveStrategy;
import racingcar.common.type.TrialCount;
import racingcar.domain.RacingCars;
import racingcar.dto.output.RoundDTO;
import racingcar.view.OutputView;

import java.util.List;

public class Game {
    private final RacingCars racingCars;
    private final MoveStrategy moveStrategy;
    private final TrialCount trialCount;

    public Game(RacingCars racingCars, MoveStrategy moveStrategy, TrialCount trialCount) {
        this.racingCars = racingCars;
        this.moveStrategy = moveStrategy;
        this.trialCount = trialCount;
    }

    public void play() {
        int count = trialCount.count();
        for (int i = 0; i < count; i++) {
            moveCars();
            printRoundResults();
        }
    }

    private void moveCars() {
        racingCars.move(moveStrategy);
    }

    private void printRoundResults() {
        List<RoundDTO> roundResults = DTOFactory.carsToRoundDTOs(racingCars.cars());
        OutputView.printRoundResult(roundResults);
    }
}
