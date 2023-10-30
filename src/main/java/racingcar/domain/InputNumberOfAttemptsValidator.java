package racingcar.domain;

public class InputNumberOfAttemptsValidator {
    boolean isNumber(String inputNumber) {
        return inputNumber.matches("^[0-9]+$");
    }
}
