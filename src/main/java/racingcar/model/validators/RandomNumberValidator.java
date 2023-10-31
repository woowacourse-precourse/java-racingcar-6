package racingcar.model.validators;

import racingcar.Exceptions.RandomNumberRangeException;

public class RandomNumberValidator implements Validator<Integer> {

    private final int MAX_RANDOM_NUMBER = 9;
    private final int MIN_RANDOM_NUMBER = 0;

    @Override
    public void validate(Integer integer) {
        validateRange(integer);
    }

    private void validateRange(Integer integer) {
        if(integer < MIN_RANDOM_NUMBER || integer > MAX_RANDOM_NUMBER) {
            throw new RandomNumberRangeException();
        }
    }
}
