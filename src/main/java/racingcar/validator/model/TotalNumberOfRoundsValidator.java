package racingcar.validator.model;

import racingcar.exception.round.NonPositiveIntegerException;
import racingcar.model.TotalNumberOfRounds;

public class TotalNumberOfRoundsValidator extends ModelValidator {
    @Override
    public void validate(Object target) {
        TotalNumberOfRounds totalNumberOfRounds = (TotalNumberOfRounds) target;
        validateTotalNumberOfRounds(totalNumberOfRounds.getTotal());
    }

    private void validateTotalNumberOfRounds(int total) {
        if (total < 0) {
            throw new NonPositiveIntegerException();
        }
    }
}
