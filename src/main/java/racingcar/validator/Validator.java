package racingcar.validator;

import java.util.List;
import racingcar.utils.Parser;

public class Validator {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final String SPACE = " ";
    private final Parser parser = new Parser();

    public void checkCarNameInput(String input) {
        checkEmptyAndThrowException(input);
        checkCommaAndThrowException(input);
        List<String> carNameList = parser.parseCarNames(input);
        checkDuplicateAndThrowException(carNameList);
        for (String carName : carNameList) {
            checkLengthAndThrowException(carName);
            checkSpaceAndThrowException(carName);
        }
    }

    public void checkAttemptNumInput(String input) {
        checkEmptyAndThrowException(input);
        checkCharAndThrowException(input);
    }

    private void checkEmptyAndThrowException(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkCharAndThrowException(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkLengthAndThrowException(String carName) {
        if (CAR_NAME_MAX_LENGTH < carName.length()
                || CAR_NAME_MIN_LENGTH > carName.length()) {
            throw new IllegalArgumentException();
        }
    }

    private void checkSpaceAndThrowException(String carName) {
        if (carName.contains(SPACE)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkCommaAndThrowException(String input) {
        if (input.lastIndexOf(",") == input.length() - 1) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDuplicateAndThrowException(List<String> carNameList) {
        for (int i = 0; i < carNameList.size(); i++) {
            for (int j = i + 1; j < carNameList.size(); j++) {
                checkEqualTwoCarNamesAndThrowException(carNameList.get(i), carNameList.get(j));
            }
        }
    }

    private void checkEqualTwoCarNamesAndThrowException(String carName1, String carName2) {
        if (carName1.equals(carName2)) {
            throw new IllegalArgumentException();
        }
    }

}
