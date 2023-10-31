package model;

import constants.Constants;
import java.util.HashMap;
import java.util.List;
import validator.AttemptTimesValidator;
import validator.NameListValidator;
import view.InputView;
import view.OutputView;

public class RaceInitializer {
    private final InputView inputView;
    private final OutputView outputView;
    private final NameListValidator nameListValidator;
    private final AttemptTimesValidator attemptTimesValidator;

    RaceInitializer(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.nameListValidator = new NameListValidator();
        this.attemptTimesValidator = new AttemptTimesValidator();
    }

    public RaceDto initRace(){
        HashMap<String, Integer> cars = new HashMap<>();
        getAndValidateNames().forEach( e -> cars.put(e, 0));
        int attemptTimes = getAndValidateAttempts();
        return new RaceDto(cars, attemptTimes);
    }

    private List<String> getAndValidateNames(){
        outputView.requestCarNames();
        String carNamesInput = inputView.getUserInput();
        nameListValidator.validate(carNamesInput);
        return nameListValidator.splitAndTrim(carNamesInput, Constants.NAME_DELIMITER);
    }

    private int getAndValidateAttempts(){
        outputView.requestAttemptTimes();
        String attemptTimesInput = inputView.getUserInput();
        attemptTimesValidator.validate(attemptTimesInput);
        return Integer.parseInt(attemptTimesInput);
    }
}
