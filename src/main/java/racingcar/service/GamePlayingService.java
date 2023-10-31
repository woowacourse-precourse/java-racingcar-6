package racingcar.service;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.dto.AttemptCount;
import racingcar.dto.RoundResult;
import racingcar.dto.TotalResult;
import racingcar.model.RacingGame;
import racingcar.model.Winners;
import racingcar.validator.AttemptCountValidator;

public class GamePlayingService {
    private final RacingGame racingGame;
    private AttemptCount attemptCount;

    public GamePlayingService(RacingGame racingGame) {
        this.racingGame = racingGame;
    }

    public void generateCars(String inputNames) {
        racingGame.generateCars(inputNames);
    }

    public void setAttemptCount(String inputCount) {
        AttemptCountValidator.INSTANCE.validate(inputCount);
        attemptCount = new AttemptCount(toInt(inputCount));
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    public TotalResult playRounds() {
        if (attemptCount == null) {
            throw new NullPointerException("시도 횟수를 먼저 입력해야합니다.");
        }

        List<RoundResult> totalResult = IntStream.range(0, attemptCount.count())
                .mapToObj(attempt -> racingGame.playRound())
                .toList();

        return new TotalResult(totalResult);
    }

    public Winners getWinners() {
        return racingGame.getWinners();
    }
}
