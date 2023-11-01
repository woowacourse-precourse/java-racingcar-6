package racingcar.gameLogic;

import java.util.List;
import racingcar.utils.InputValidator;
import racingcar.utils.StringChanger;
import racingcar.views.InputViewer;

public class User {
    public List<String> inputCarName() {
        String userInput = InputViewer.requestCarNameInput();
        return requestValidateCarNames(userInput);
    }

    public int inputNumberOfTry() {
        String userInput = InputViewer.requestNumberOfTry();
        return requestValidateTryInput(userInput);
    }

    private List<String> requestValidateCarNames(String userInput) {
        List<String> carNameList = requestStringToList(userInput);
        InputValidator.validateNumberOfCars(carNameList.size());
        InputValidator.validateIsNamesDistinct(carNameList);
        for (String carName : carNameList) {
            InputValidator.validateNameLength(carName.length());
        }
        return carNameList;
    }

    private int requestValidateTryInput(String userInput) {
        int numberOfTry;
        userInput = requestStringTrimmed(userInput);
        InputValidator.validateIsInputNumber(userInput);
        numberOfTry = requestStringToInteger(userInput);
        InputValidator.validateIsNaturalNumber(numberOfTry);
        return numberOfTry;
    }

    private List<String> requestStringToList(String userInput) {
        return StringChanger.stringToStringList(userInput);
    }

    private String requestStringTrimmed(String userInput) {
        return StringChanger.stringToTrimmedString(userInput);
    }

    private int requestStringToInteger(String userInput) {
        return StringChanger.stringToInteger(userInput);
    }
}
