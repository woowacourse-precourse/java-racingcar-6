package racingcar.util;

import java.util.List;

public class Validator {
    private static final int NAME_LENGTH_MIN = 1;
    private static final int NAME_LENGTH_MAX = 5;
    private static final String SPACE = " ";
    private final CommaDetector commaDetector = new CommaDetector();

    public void validateInputNames(String input) throws IllegalArgumentException {
        checkEmptyAndThrowException(input);
        checkIndexAndThrowException(input);
        List<String> carNameList = commaDetector.divideCarNames(input);
        checkNameListThrowException(carNameList);
        checkNamesThrowException(carNameList);
    }

    private void checkNamesThrowException(@org.jetbrains.annotations.NotNull List<String> carNameList) {
        for (String carName : carNameList) {
            checkLengthAndThrowException(carName);
            checkSpaceAndThrowException(carName);

        }
    }

    public void checkNumberOfTrialInput(String input) throws IllegalArgumentException {
        checkEmptyAndThrowException(input);
        checkCharAndThrowException(input);
    }

    private void checkCharAndThrowException(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] : 숫자를 입력 해야 합니다.");
        }
    }

    private void checkEmptyAndThrowException(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 값이 없습니다.");
        }
    }

    private void checkNameListThrowException(List<String> carNameList) {
        for (int i = 0; i < carNameList.size(); i++) {
            for (int j = i + 1; j < carNameList.size(); j++) {
                checkEqualsAndThrowException(carNameList.get(i), carNameList.get(j));
            }
        }
    }

    private void checkEqualsAndThrowException(String carName1, String carName2) {
        if (carName1.equals(carName2)) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름이 있습니다.");
        }
    }

    private void checkIndexAndThrowException(String input) {
        if (input.lastIndexOf(",") == input.length() - 1) {
            throwMinLengthException();
        }
    }

    private void checkLengthAndThrowException(String carName) {
        if (NAME_LENGTH_MAX < carName.length()) {
            throwMaxLengthException();
        }
        if (carName.isEmpty()) {
            throwMinLengthException();
        }
    }

    private void throwMinLengthException() {
        throw new IllegalArgumentException("[ERROR] : 이름은 " + NAME_LENGTH_MIN + "글자 이상이어야 합니다.");
    }

    private void throwMaxLengthException() {
        throw new IllegalArgumentException("[ERROR] : 이름은 " + NAME_LENGTH_MAX + "글자 이하여야 합니다.");
    }

    private void checkSpaceAndThrowException(String carName) {
        if (carName.contains(SPACE)) {
            throwSpaceException();
        }
    }

    private void throwSpaceException() {
        throw new IllegalArgumentException("[ERROR] 공백이 없어야 합니다.");
    }
}
