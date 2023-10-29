package racingcar.controller;

import java.util.ArrayList;
import racingcar.common.factory.DTOFactory;
import racingcar.common.strategy.MoveStrategy;
import racingcar.common.type.TrialCount;
import racingcar.domain.RacingCars;
import racingcar.dto.output.AllRoundDTO;
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

    public List<AllRoundDTO> play() {
        List<AllRoundDTO> allRoundResults = new ArrayList<>();
        int count = trialCount.count();

        for (int i = 0; i < count; i++) {
            moveCars();
            allRoundResults.add(fetchRoundResult());
        }

        return allRoundResults;
    }

    private void moveCars() {
        racingCars.move(moveStrategy);
    }

    private AllRoundDTO fetchRoundResult() {
        return DTOFactory.createAllRoundDTO(racingCars.cars());
    }
}
