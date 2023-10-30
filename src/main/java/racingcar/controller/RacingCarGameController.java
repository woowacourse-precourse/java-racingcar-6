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
        List<String> carNames = inputCarNames();
        LinkedHashMap<String, Integer> racingProgressStatus = racingProgressStatusInitialize(carNames);
        int attemptCount = inputAttemptCount();
        printExecutionResultMessage();
        for (int i = 0; i < attemptCount; i++) {
            proceedOneRound(racingNumberGenerator, carNames, racingProgressStatus);
            printExecutionResult(racingProgressStatus);
        }
        List<String> winners = getWinners(racingProgressStatus);
        printWinners(winners);
    }

    private List<String> inputCarNames() {
        printInputRacingCarNamesMessage();
        return getCarNames();
    }

    private void printInputRacingCarNamesMessage() {
        outputView.printInputRacingCarNamesMessage();
    }

    private List<String> getCarNames() {
        return inputView.readCarNames();
    }

    private LinkedHashMap<String, Integer> racingProgressStatusInitialize(List<String> carNames) {
        LinkedHashMap<String, Integer> racingProgressStatus = new LinkedHashMap<>();
        new RacingCarNames(carNames);
        for (String carName : carNames) {
            racingProgressStatus.put(carName, 0);
        }
        return racingProgressStatus;
    }

    private int inputAttemptCount() {
        printInputAttemptCountMessage();
        int attemptCount = getAttemptCount();
        System.out.println();
        return attemptCount;
    }

    private void printInputAttemptCountMessage() {
        outputView.printInputAttemptCountMessage();
    }

    private int getAttemptCount() {
        return inputView.readAttemptCount();
    }

    private void printExecutionResultMessage() {
        outputView.printExecutionResultMessage();
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

    private void printExecutionResult(LinkedHashMap<String, Integer> racingProgressStatus) {
        outputView.printExecutionResult(racingProgressStatus);
    }

    private List<String> getWinners(LinkedHashMap<String, Integer> racingProgressStatus) {
        return racingCarGameService.getWinners(racingProgressStatus);
    }

    private void printWinners(List<String> winners) {
        outputView.printWinners(winners);
    }
}
