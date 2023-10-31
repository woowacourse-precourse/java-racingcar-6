package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.common.type.TrialCount;
import racingcar.domain.RacingCars;
import racingcar.dto.output.AllRoundDTO;

public class Game {
    private final RacingCars racingCars;

    private Game(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public static Game of(RacingCars racingCars) {
        return new Game(racingCars);
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
        return AllRoundDTO.of(racingCars.cars());
    }
}
