package racingcar.service;

import java.util.List;
import racingcar.domain.AttemptCounts;
import racingcar.domain.CarEngine;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.dto.RacingResultDto;
import racingcar.dto.RacingRoundResultDto;
import racingcar.dto.UserAttemptCountsDto;
import racingcar.dto.UserCarNameDto;

public class RacingCarService {
    private final CarEngine carEngine;
    private RacingGame racingGame;

    public RacingCarService(CarEngine carEngine) {
        this.carEngine = carEngine;
    }

    public void initializeRacingGame(UserCarNameDto userCarNameDto, UserAttemptCountsDto userAttemptCountsDto) {
        List<String> inputCarNames = userCarNameDto.carNames();
        String inputAttemptCounts = userAttemptCountsDto.attemptCounts();
        this.racingGame = RacingGame.of(Cars.from(inputCarNames, this.carEngine),
                AttemptCounts.from(inputAttemptCounts));
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
