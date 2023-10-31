package racingcar.validator;

import racingcar.model.RoundNumber;

public class RoundNumberValidation {
    private String roundNumber;

    public RoundNumberValidation(String roundNumber) {
        this.roundNumber = roundNumber;
        validate();
    }

    private void validate() {
        isEmpty();
    }

    private void isEmpty() {
        if (roundNumber.isEmpty()) {
            throw new IllegalArgumentException("라운드 회수를 입력해주셔야 합니다.");
        }
    }
}
