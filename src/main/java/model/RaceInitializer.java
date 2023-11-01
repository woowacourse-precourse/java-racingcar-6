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
        HashMap<String, Integer> carNames = initCarNames();
        int attemptTimes = getAndValidateAttempts();
        return new RaceDto(carNames, attemptTimes);
    }

    private HashMap<String, Integer> initCarNames(){
        HashMap<String, Integer> cars = new HashMap<>();
        getAndValidateNames().forEach( e -> cars.put(e, 0));
        return cars;
    }

    private List<String> getAndValidateNames(){
        outputView.requestCarNames();
        String carNamesInput = inputView.getUserInput();
        return nameListValidator.getValidatedValue(carNamesInput);
    }

    private int getAndValidateAttempts(){
        outputView.requestAttemptTimes();
        String attemptTimesInput = inputView.getUserInput();
        return attemptTimesValidator.getValidatedValue(attemptTimesInput);
    }
}
