package controller;

import validator.AttemptTimesValidator;
import validator.NameListValidator;
import view.InputView;
import view.OutputView;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NameListValidator nameListValidator;
    private final AttemptTimesValidator attemptTimesValidator;

    RaceController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.nameListValidator = new NameListValidator();
        this.attemptTimesValidator = new AttemptTimesValidator();
    }

    private void PrepareRace(){
        outputView.requestCarNames();
        String carNames = inputView.getUserInput();
        nameListValidator.validate(carNames);

        outputView.requestAttemptTimes();
        String attemptTimes = inputView.getUserInput();
        attemptTimesValidator.validate(attemptTimes);
    }
}
