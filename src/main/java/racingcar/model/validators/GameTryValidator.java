package racingcar.model.validators;

import racingcar.Exceptions.GameTryRangeException;

public class GameTryValidator implements Validator<Integer> {
    private final int MIN = 0;
    private final int MAX = Integer.MAX_VALUE;

    @Override
    public void validate(Integer input) {
        validateGameTryRange(input);
    }

    private void validateGameTryRange(Integer input) {
        if (input < MIN || input > MAX)
            throw new GameTryRangeException();
    }
}
