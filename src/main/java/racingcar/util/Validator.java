package racingcar.util;

import java.util.List;
import racingcar.Constant;

public class Validator {

    private final Parser parser = new Parser();

    public void checkCarNamesInput(String input) throws IllegalArgumentException {
        checkEmptyAndThrowException(input);
        checkLastIndexAndThrowException(input);
        List<String> carNames = parser.parseCarNames(input);
        checkCarNameListDuplicationAndThrowException(carNames);
        checkCarNameLengthAndSpaceThrowException(carNames);
    }

    public void checkNumberOfTrialInput(String input) throws IllegalArgumentException {
        checkEmptyAndThrowException(input);
        checkCharAndThrowException(input);
    }

    private void checkCarNameLengthAndSpaceThrowException(List<String> carNames) throws IllegalArgumentException {
        for (String carName : carNames) {
            checkLengthAndThrowException(carName);
            checkSpaceAndThrowException(carName);
        }
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

    private void checkLastIndexAndThrowException(String input) {
        if (input.lastIndexOf(",") == input.length() - 1) {
            throw new IllegalArgumentException();
        }
    }

    private void checkLengthAndThrowException(String carName) {
        if (Constant.CAR_NAME_LENGTH_MAX < carName.length()) {
            throw new IllegalArgumentException();
        }
        if (carName.length() < Constant.CAR_NAME_LENGTH_MIN) {
            throw new IllegalArgumentException();
        }
    }

    private void checkSpaceAndThrowException(String carName) {
        if (carName.contains(Constant.SPACE)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkCarNameListDuplicationAndThrowException(List<String> carNames) throws IllegalArgumentException {
        for (int i = 0; i < carNames.size(); i++) {
            for (int j = i + 1; j < carNames.size(); j++) {
                checkEqualsAndThrowException(carNames.get(i), carNames.get(j));
            }
        }
    }

    private void checkEqualsAndThrowException(String carName1, String carName2) {
        if (carName1.equals(carName2)) {
            throw new IllegalArgumentException();
        }
    }
}
