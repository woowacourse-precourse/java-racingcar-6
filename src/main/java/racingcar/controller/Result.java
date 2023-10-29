package racingcar.controller;

import java.util.List;
import racingcar.common.factory.DTOFactory;
import racingcar.domain.RacingWinners;
import racingcar.dto.output.WinnerDTO;
import racingcar.view.OutputView;

public class Result {
    private final RacingWinners racingWinners;

    public Result(RacingWinners racingWinners) {
        this.racingWinners = racingWinners;
    }

    public void announce() {
        List<String> winnerNames = racingWinners.getWinnerNames();
        WinnerDTO winnerDTO = createWinnerDTO(winnerNames);
        OutputView.printWinner(winnerDTO);
    }

    private WinnerDTO createWinnerDTO(List<String> winnerNames) {
        return DTOFactory.createWinnerDTO(winnerNames);
    }
}
