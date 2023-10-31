package racingcar.controller;

import java.util.List;
import racingcar.domain.RoundCount;
import racingcar.dto.GameResultDto;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGameService racingGameService;

    public RacingGameController(InputView inputView, OutputView outputView, RacingGameService racingGameService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGameService = racingGameService;
    }

    public void runRacingGame() {
        List<String> carNames = inputView.readCarNames();
        RoundCount roundCount = inputView.readNumberOfRounds();
        GameResultDto result = racingGameService.run(carNames, roundCount);
        outputView.showGameResult(result);
    }

}
