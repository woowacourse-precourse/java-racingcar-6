package racingcar.model;

import java.util.regex.Matcher;
import racingcar.enums.ErrorMessage;
import racingcar.enums.GameConstant;

public class AttempsCount {
    private final Integer MAX_ATTEMPTS_COUNT;
    private Integer currentAttempsCount;

    public AttempsCount(String attempsCount) {
        validatePositiveNumber(attempsCount);

        this.MAX_ATTEMPTS_COUNT = Integer.parseInt(attempsCount);
        this.currentAttempsCount = 0;
    }

    private void validatePositiveNumber(String attempsCount) {
        Matcher positiveNumberMatcher = GameConstant.POSITIVE_NUMBER_PATTERN.matcher(attempsCount);

        if (positiveNumberMatcher.matches() == false) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OF_ATTEMPTS_RANGE.getMessage());
        }
    }

    public Boolean checkCountEqualToMax() {
        return (this.currentAttempsCount == this.MAX_ATTEMPTS_COUNT);
    }

    public void increaseAttempsCount() {
        ++this.currentAttempsCount;
    }
}
