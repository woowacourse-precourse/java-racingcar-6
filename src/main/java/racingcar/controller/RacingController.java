package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.service.RacingService;
import racingcar.util.InputValidator;
import racingcar.view.OutputHandler;

public class RacingController {

    RacingService racingService = new RacingService();

    public void start() {
        initRacing();
        startRacing();
        endRacing();
    }

    private void initRacing() {
        OutputHandler.printRequestCarNames();
        List<String> carNames = getCarNames();
        if (InputValidator.isValidInputLength(carNames) || InputValidator.isExistSameName(
            carNames)) {
            throw new IllegalArgumentException();
        }

        OutputHandler.printRequestNumberOfAttempt();
        int numberOfAttempt = getNumberOfAttempt();
        if (InputValidator.isSmallerThanOne(numberOfAttempt)) {
            throw new IllegalArgumentException();
        }

        racingService.initRacing(carNames, numberOfAttempt);
    }

    private void startRacing() {
        racingService.startRacing();
    }

    private void endRacing() {
        racingService.endRacing();
    }

    private List<String> getCarNames() {
        String userInput = Console.readLine();
        if (InputValidator.isEmptyString(userInput)) {
            throw new IllegalArgumentException();
        }

        return Arrays.asList(userInput.split(","));
    }

    private int getNumberOfAttempt() {
        String numberOfAttempt = Console.readLine();
        if (InputValidator.isNotNumber(numberOfAttempt)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(numberOfAttempt);
    }
}
