package racingcar.service;

import java.util.List;
import racingcar.domain.AttemptCounts;
import racingcar.domain.CarEngine;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.dto.RacingResultDto;
import racingcar.dto.RacingRoundResultDto;

public class RacingCarService {
    private final CarEngine carEngine;
    private RacingGame racingGame;

    public RacingCarService(CarEngine carEngine) {
        this.carEngine = carEngine;
    }

    public void initializeRacingGame(List<String> carNames, String attemptCounts) {
        this.racingGame = RacingGame.of(Cars.from(carNames, this.carEngine), AttemptCounts.from(attemptCounts));
    }

    public RacingRoundResultDto race() {
        return RacingRoundResultDto.from(racingGame.play());
    }

    public boolean isRemainAttemptCounts() {
        return this.racingGame.isRemainAttemptCounts();
    }

    public RacingResultDto determineWinner() {
        return RacingResultDto.from(racingGame.getWinners());
    }
}
