package racingcar.dto.request;

import racingcar.exception.InvalidTryCountException;

public class TryCount {

    private final Integer count;

    private TryCount(Integer count) {
        validateNonNegativeCount(count);
        this.count = count;
    }

    public static TryCount fromInput(String input) {
        try {
            return new TryCount(Integer.valueOf(input));
        } catch (NumberFormatException e) {
            throw new InvalidTryCountException();
        }
    }

    public Integer getCount() {
        return count;
    }

    private void validateNonNegativeCount(Integer count) {
        if (count < 0) {
            throw new InvalidTryCountException();
        }
    }
}
