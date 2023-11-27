package racingcar.view.input.parser;

import static racingcar.view.input.constant.InputSymbolConstant.BLANK;
import static racingcar.view.input.constant.InputSymbolConstant.CAR_NAME_DELIMITER;
import static racingcar.view.input.constant.InputSymbolConstant.VOID;

import java.util.Arrays;
import java.util.List;
import racingcar.view.input.validator.CarNameInputValidator;
import racingcar.view.input.validator.CarNamesInputValidator;
import racingcar.view.input.validator.TrialTimesValidator;

public class InputParser {
    private final CarNameInputValidator carNameInputValidator;
    private final CarNamesInputValidator carNamesInputValidator;
    private final TrialTimesValidator trialTimesValidator;

    public InputParser() {
        carNameInputValidator = new CarNameInputValidator();
        carNamesInputValidator = new CarNamesInputValidator();
        trialTimesValidator = new TrialTimesValidator();
    }

    public List<String> parseToCarNames(String userInput) {
        userInput = removeBlank(userInput);
        carNamesInputValidator.validate(userInput);
        validateEachCarName(userInput);
        return parseToStrings(userInput);
    }

    public int parseToTrialTimes(String userInput) {
        userInput = removeBlank(userInput);
        trialTimesValidator.validate(userInput);
        return parseToInt(userInput);
    }

    private List<String> parseToStrings(String userInput) {
        return Arrays.stream(userInput.split(CAR_NAME_DELIMITER.getSymbol()))
                .toList();
    }

    private int parseToInt(String userInput) {
        return Integer.parseInt(userInput);
    }

    private String removeBlank(String userInput) {
        if (userInput.contains(BLANK.getSymbol())) {
            userInput = userInput.replace(BLANK.getSymbol(), VOID.getSymbol());
        }
        return userInput;
    }

    private void validateEachCarName(String userInput) {
        Arrays.stream(userInput.split(CAR_NAME_DELIMITER.getSymbol()))
                .forEach(carNameInputValidator::validate);
    }
}