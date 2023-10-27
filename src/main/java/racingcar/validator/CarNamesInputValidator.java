package racingcar.validator;

import java.util.Arrays;

public class CarNamesInputValidator implements InputValidator {

    @Override
    public void validate(String input) {
        isInputEmpty(input);
        hasLessThanTwoCarNames(input);
        hasDuplicateCarNames(input);
        hasSpecialCharacters(input);
        isEachCarNameLengthValid(input);
    }

    private void isInputEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    private void hasLessThanTwoCarNames(String input) {
        if (input.split(",").length < 2) {
            throw new IllegalArgumentException("자동차 이름은 2개 이상이어야 합니다.");
        }
    }

    private void hasDuplicateCarNames(String input) {
        if (isDuplicate(input)) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }

    private void hasSpecialCharacters(String input) {
        if (!input.matches("^[a-zA-Z0-9\\s가-힣]*$")) {
            throw new IllegalArgumentException("자동차 이름에는 특수문자가 포함될 수 없습니다.");
        }
    }

    private void isCarNameLengthValid(String carName) {
        if (carName.length() > 5 || carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
        }
    }

    private void isEachCarNameLengthValid(String input) {
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            isCarNameLengthValid(carName);
        }
    }

    private boolean isDuplicate(String input) {
        String[] carNames = input.split(",");
        long deduplicationCount = Arrays.stream(carNames)
                .distinct()
                .count();
        return carNames.length != deduplicationCount;
    }
}
