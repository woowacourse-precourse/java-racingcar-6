package racingcar.controller;

import java.util.List;
import racingcar.common.factory.DTOFactory;
import racingcar.domain.RacingWinners;
import racingcar.dto.output.WinnerDTO;

public class Result {
    private final RacingWinners racingWinners;

    public Result(RacingWinners racingWinners) {
        this.racingWinners = racingWinners;
    }

    public WinnerDTO announce() {
        List<String> winnerNames = racingWinners.getWinnerNames();
        return createWinnerDTO(winnerNames);
    }

    private WinnerDTO createWinnerDTO(List<String> winnerNames) {
        return DTOFactory.createWinnerDTO(winnerNames);
    }
}
