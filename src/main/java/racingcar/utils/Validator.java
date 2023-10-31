package racingcar.utils;

import java.util.List;

public class Validator {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String WRONG_LENGTH_CAR_NAME_ERROR_MESSAGE = "이름은 5자 이하여야 합니다";

    Parser parser = new Parser();

    public String validateCarNameInput(String userInput) {
        List<String> carNameList = parser.parseCarNameInput(userInput);
        validateLengthForCarNameInput(carNameList);

        return userInput;
    }

    private void validateLengthForCarNameInput(List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > CAR_NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(WRONG_LENGTH_CAR_NAME_ERROR_MESSAGE);
            }
        }
    }
}
