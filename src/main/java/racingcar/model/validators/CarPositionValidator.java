package racingcar.model.validators;

import racingcar.Exceptions.CarPositionRangeException;

public class CarPositionValidator implements Validator<Integer> {
    final int MIN = 0;
    final int MAX = Integer.MAX_VALUE;

    @Override
    public void validate(Integer value) {
        validateRangeOfRandomNumber(value);
    }

    private void validateRangeOfRandomNumber(Integer value) {
        if (value < MIN || value > MAX) {
            throw new CarPositionRangeException();
        }
    }
}
