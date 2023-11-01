package racingcar.domain.entity.valueobject;

import racingcar.domain.util.validator.ChallengeValidator;

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
