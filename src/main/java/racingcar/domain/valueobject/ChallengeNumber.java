package racingcar.domain.valueobject;

import racingcar.domain.validator.ChallengeNumberValidator;

public class ChallengeNumber {
    private int challengeNumber;

    public ChallengeNumber(String challengeNumber) {
        ChallengeNumberValidator.validate(challengeNumber);
        this.challengeNumber = Integer.valueOf(challengeNumber);
    }

    public int getValue() {
        return challengeNumber;
    }
}
