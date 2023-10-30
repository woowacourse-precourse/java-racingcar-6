package racingcar.controller;

import racingcar.model.RacingCarNames;
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
        LinkedHashMap<String, Integer> racingProgressStatus = racingProgressStatusInitialize(carNames);
        outputView.printInputAttemptCountMessage();
        int attemptCount = inputView.readAttemptCount();
        outputView.printExecutionResultMessage();
        for (int i = 0; i < attemptCount; i++) {
            proceedOneRound(racingNumberGenerator, carNames, racingProgressStatus);
            outputView.printExecutionResult(racingProgressStatus);
        }
        List<String> winners = racingCarGameService.getWinners(racingProgressStatus);
        outputView.printWinners(winners);
    }

    private LinkedHashMap<String, Integer> racingProgressStatusInitialize(List<String> carNames) {
        LinkedHashMap<String, Integer> racingProgressStatus = new LinkedHashMap<>();
        new RacingCarNames(carNames);
        for (String carName : carNames) {
            racingProgressStatus.put(carName, 0);
        }
        return racingProgressStatus;
    }

    private void proceedOneRound(
            RandomNumberGenerator racingNumberGenerator,
            List<String> carNames,
            LinkedHashMap<String, Integer> racingProgressStatus
    ) {
        for (String carName : carNames) {
            int randomNumber = racingNumberGenerator.getRandomNumber();
            decideMovingForward(randomNumber, racingProgressStatus, carName);
        }
    }

    private void decideMovingForward(
            int randomNumber,
            LinkedHashMap<String, Integer> racingProgressStatus,
            String carName
    ) {
        if (racingCarGameService.isMovingForward(randomNumber)) {
            racingCarGameService.moveForward(racingProgressStatus, carName);
        }
    }
}
