package util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validate {
    public String validateInputLineOfCarNames(String inputLineOfCarNames) {
        if (inputLineOfCarNames.startsWith(",") || inputLineOfCarNames.endsWith(",")) {
            throw new IllegalArgumentException("입력 형식이 맞지 않습니다.");
        }
        return inputLineOfCarNames;
    }
    public List<String> checkCarNames(List<String> carNames) {
        checkCarNameForm((carNames));
        validateDuplicateOfCarName((carNames));
        return carNames;
    }
    private void checkCarNameForm(List<String> carNames) {
        carNames.forEach(carName -> {
            validateCarNameRegex(carName);
            validateMaxLengthOfCarName(carName);
        });
    }

    private void validateCarNameRegex(String carName) {
        String regex = "^[a-zA-Z]+[a-zA-Z0-9]*$";
        if (!Pattern.matches(regex, carName)) {
            throw new IllegalArgumentException("이름 형식이 맞지 않습니다.");
        }
    }

    private void validateMaxLengthOfCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름 길이가 초과했습니다.");
        }
    }

    private void validateDuplicateOfCarName(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<String>();
        carNames.forEach(carName -> {
            if (!uniqueNames.add(carName)) {
                throw new IllegalStateException("이름이 중복됩니다.");
            }
        });
    }

    public String checkNumberOfAttemptsForm(String numberOfAttempts) {
        validateIsNumber(numberOfAttempts);
        validateIsZero(numberOfAttempts);
        return numberOfAttempts;
    }

    private void validateIsNumber(String numberOfAttempts) {
        String numberRegex = "^[0-9]*$";
        if (!Pattern.matches(numberRegex,numberOfAttempts)) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다.");
        }
    }

    private void validateIsZero(String numberOfAttempts) {
        if (Pattern.matches("0",numberOfAttempts)) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
    }

}
