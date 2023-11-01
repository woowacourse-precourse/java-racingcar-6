package model;

import constants.Constants;
import java.util.HashMap;
import java.util.List;
import validator.AttemptTimesValidator;
import validator.NameListValidator;
import view.InputView;
import view.OutputView;

public class RaceInitializer {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final NameListValidator nameListValidator = new NameListValidator();
    private final AttemptTimesValidator attemptTimesValidator  = new AttemptTimesValidator();

    public RaceDto initRace(){
        List<String> carNames = getAndValidateNames();
        int attemptTimes = getAndValidateAttempts();
        HashMap<String, String> carNameToAdvanceMap = makeHashMapInitializedKeyBy(carNames);
        return new RaceDto(carNameToAdvanceMap, attemptTimes);
    }

    private HashMap<String, String> makeHashMapInitializedKeyBy(List<String> names){
        HashMap<String, String> cars = new HashMap<>();
        names.forEach( e -> cars.put(e, ""));
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
