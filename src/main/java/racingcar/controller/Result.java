package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingWinners;
import racingcar.dto.output.WinnerDTO;

public class Result {
    private final RacingWinners racingWinners;

    private Result(RacingWinners racingWinners) {
        this.racingWinners = racingWinners;
    }

    public static Result of(RacingWinners racingWinners) {
        return new Result(racingWinners);
    }

    public WinnerDTO announce() {
        List<String> winnerNames = racingWinners.getWinnerNames();
        return createWinnerDTO(winnerNames);
    }

    private WinnerDTO createWinnerDTO(List<String> winnerNames) {
        return WinnerDTO.of(winnerNames);
    }
}
