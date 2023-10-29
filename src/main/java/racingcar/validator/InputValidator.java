package racingcar.validator;


public class InputValidator {

    public void validateCarNameEmptyOrNull(String names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있으면 안됩니다.");
        }
    }
}
