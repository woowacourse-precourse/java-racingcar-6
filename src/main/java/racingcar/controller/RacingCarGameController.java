package racingcar.controller;

import racingcar.service.RacingCarGameService;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.LinkedHashMap;
import java.util.List;

public class RacingCarGameController {

    private final RacingCarGameService racingCarGameService;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGameController(
            RacingCarGameService racingCarGameService,
            InputView inputView,
            OutputView outputView
    ) {
        this.racingCarGameService = racingCarGameService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playRacingCarGame(RandomNumberGenerator racingNumberGenerator) {
        outputView.printInputRacingCarNamesMessage();
        List<String> carNames = inputView.readCarNames();
        LinkedHashMap<String, Integer> racingProgressStatus = racingCarGameService.racingProgressStatusInitialize(carNames);
        outputView.printInputAttemptCountMessage();
        int attemptCount = inputView.readAttemptCount();
        outputView.printExecutionResultMessage();
        for (int i = 0; i < attemptCount; i++) {
            racingCarGameService.proceedOneRound(racingNumberGenerator, carNames, racingProgressStatus);
            outputView.printExecutionResult(racingProgressStatus);
        }
        List<String> winners = racingCarGameService.getWinners(racingProgressStatus);
        outputView.printWinners(winners);
    }
}
