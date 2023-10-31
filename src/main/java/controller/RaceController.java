package controller;

import constants.Constants;
import java.util.HashMap;
import java.util.List;
import validator.AttemptTimesValidator;
import validator.NameListValidator;
import view.InputView;
import view.OutputView;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final NameListValidator nameListValidator;
    private final AttemptTimesValidator attemptTimesValidator;

    private HashMap<String, Integer> cars;
    private int attemptTimes;

    RaceController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.nameListValidator = new NameListValidator();
        this.attemptTimesValidator = new AttemptTimesValidator();

        this.cars = new HashMap<>();
        this.attemptTimes = 0;
    }

    private void PrepareRace(){
        outputView.requestCarNames();
        String carNamesInput = inputView.getUserInput();
        nameListValidator.validate(carNamesInput);

        outputView.requestAttemptTimes();
        String attemptTimesInput = inputView.getUserInput();
        attemptTimesValidator.validate(attemptTimesInput);

        List<String> validatedNames
                = nameListValidator.splitAndTrim(carNamesInput, Constants.NAME_DELIMITER);
        validatedNames.forEach( e -> this.cars.put(e, 0));
        this.attemptTimes = Integer.parseInt(attemptTimesInput);
    }
}