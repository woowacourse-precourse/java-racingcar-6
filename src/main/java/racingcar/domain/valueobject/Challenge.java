package racingcar.domain.valueobject;

import racingcar.domain.validator.ChallengeValidator;

public class Challenge {
    private int number;

    public Challenge(String number) {
        ChallengeValidator.validate(number);
        this.number = Integer.valueOf(number);
    }

    public int getNumber() {
        return number;
    }
}
