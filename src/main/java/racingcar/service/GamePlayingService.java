package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.AttemptCount;
import racingcar.dto.RoundResult;
import racingcar.dto.TotalResult;
import racingcar.model.RacingGame;
import racingcar.model.Winners;
import racingcar.validator.AttemptCountValidator;

public class GamePlayingService {
    private final RacingGame racingGame;

    public GamePlayingService(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void generateCars(String inputNames) {
        racingGame.generateCars(inputNames);
    }

    public AttemptCount createAttemptCount(String input) {
        AttemptCountValidator.INSTANCE.validate(input);

        return new AttemptCount(toInt(input));
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    public TotalResult playRounds(int count) {
        List<RoundResult> totalResult = new ArrayList<>();

        for (int current = 0; current < count; current++) {
            racingGame.tryForward();
            totalResult.add(getCarsState());
        }

        return new TotalResult(totalResult);
    }

    public RoundResult getCarsState() {
        return racingGame.getCarsState();
    }

    public Winners getWinners() {
        return racingGame.getWinners();
    }
}
