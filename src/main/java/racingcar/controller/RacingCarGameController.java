package racingcar.controller;

import java.util.LinkedHashMap;
import java.util.List;
import racingcar.RandomNumberGenerator;
import racingcar.model.RacingCarName;
import racingcar.service.RacingCarGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {

    private final RacingCarGameService racingCarGameService;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarGameController(RacingCarGameService racingCarGameService,
                                   InputView inputView,
                                   OutputView outputView) {
        this.racingCarGameService = racingCarGameService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playRacingCarGame(RandomNumberGenerator racingNumberGenerator) {
        List<String> carNames = inputCarNames();
        LinkedHashMap<String, Integer> progressStatus = progressStatusInitialize(carNames);
        int attemptCount = inputAttemptCount();
        printExecutionResultMessage();
        for (int i = 0; i < attemptCount; i++) {
            proceedOneRound(racingNumberGenerator, carNames, progressStatus);
            printExecutionResult(progressStatus);
        }
        List<String> winners = getWinners(progressStatus);
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

    private LinkedHashMap<String, Integer> progressStatusInitialize(List<String> carNames) {
        LinkedHashMap<String, Integer> progressStatus = new LinkedHashMap<>();
        for (String carName : carNames) {
            new RacingCarName(carName);
            progressStatus.put(carName, 0);
        }
        return progressStatus;
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

    private void proceedOneRound(RandomNumberGenerator racingNumberGenerator,
                                 List<String> carNames,
                                 LinkedHashMap<String, Integer> progressStatus) {
        for (String carName : carNames) {
            int randomNumber = racingNumberGenerator.getRandomNumber();
            decideMovingForward(randomNumber, progressStatus, carName);
        }
    }

    private void decideMovingForward(int randomNumber, LinkedHashMap<String, Integer> progressStatus, String carName) {
        if (racingCarGameService.isMovingForward(randomNumber)) {
            racingCarGameService.moveForward(progressStatus, carName);
        }
    }

    private void printExecutionResult(LinkedHashMap<String, Integer> progressStatus) {
        outputView.printExecutionResult(progressStatus);
    }

    private List<String> getWinners(LinkedHashMap<String, Integer> progressStatus) {
        return racingCarGameService.getWinners(progressStatus);
    }

    private void printWinners(List<String> winners) {
        outputView.printWinners(winners);
    }
}
