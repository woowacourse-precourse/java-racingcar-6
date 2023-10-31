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

    public Game(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public List<AllRoundDTO> play(TrialCount trialCount) {
        List<AllRoundDTO> allRoundResults = new ArrayList<>();
        int count = trialCount.getCount();

        for (int i = 0; i < count; i++) {
            moveCars();
            allRoundResults.add(fetchRoundResult());
        }

        return allRoundResults;
    }

    private void moveCars() {
        racingCars.move();
    }

    private AllRoundDTO fetchRoundResult() {
        return DTOFactory.createAllRoundDTO(racingCars.cars());
    }
}
