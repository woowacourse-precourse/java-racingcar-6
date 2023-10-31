package racingcar.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String WRONG_LENGTH_CAR_NAME_ERROR_MESSAGE = "이름은 5자 이하여야 합니다";
    private static final String CAR_NAME_DUPLICATION_ERROR_MESSAGE = "이름이 중복되어선 안됩니다";
    private static final String CAR_NAME_BLANK_ERROR_MESSAGE = "이름이 비어있으면 안 됩니다";
    
    Parser parser = new Parser();

    public String validateCarNameInput(String userInput) {
        List<String> carNameList = parser.parseCarNameInput(userInput);
        validateLengthForCarNameInput(carNameList);
        validateDuplicateForCarNameInput(carNameList);
        validateBlankForCarNameInput(carNameList);

        return userInput;
    }

    private void validateLengthForCarNameInput(List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.length() > CAR_NAME_MAX_LENGTH) {
                throw new IllegalArgumentException(WRONG_LENGTH_CAR_NAME_ERROR_MESSAGE);
            }
        }
    }

    private void validateDuplicateForCarNameInput(List<String> carNameList) {
        Set<String> set = new HashSet<>();
        set.addAll(carNameList);
        if (set.size() != carNameList.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATION_ERROR_MESSAGE);
        }
    }

    private void validateBlankForCarNameInput(List<String> carNameList) {
        for (String carName : carNameList) {
            if (carName.isBlank()) {
                throw new IllegalArgumentException(CAR_NAME_BLANK_ERROR_MESSAGE);
            }
        }
    }
}
