package racingcar.validator;

import racingcar.model.RoundNumber;

public class RoundNumberValidator {
    private String roundNumber;

    public RoundNumberValidator(String roundNumber) {
        this.roundNumber = roundNumber;
        validate();
    }

    private void validate() {
        isEmpty();
        isNumeric();
    }

    private void isEmpty() {
        if (roundNumber.isEmpty()) {
            throw new IllegalArgumentException("라운드 회수를 입력해주셔야 합니다.");
        }
    }

    private void isNumeric() {
        if (!roundNumber.matches("[1-9][0-9]*")) {
            throw new IllegalArgumentException("시도 회수는 1 이상의 정수를 입력해주셔야 합니다.");
        }
    }
}
