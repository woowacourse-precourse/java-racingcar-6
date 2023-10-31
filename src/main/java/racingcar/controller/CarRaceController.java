package racingcar.controller;

import racingcar.validator.AttemptNumberValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarRaceController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void startRace() {
        List<String> carNames = inputView.inputCarNames();

        int numberOfAttempts = AttemptNumberValidator.validateNumber(inputView.inputNumberOfAttempts());
    }
}