package racingcar.validator.model;

import racingcar.exception.round.NonPositiveIntegerException;
import racingcar.model.TotalNumberOfRounds;

public class TotalNumberOfRoundsValidator extends ModelValidator {
    private static TotalNumberOfRoundsValidator totalNumberOfRoundsValidator = new TotalNumberOfRoundsValidator();

    private TotalNumberOfRoundsValidator() {
    }

    public static TotalNumberOfRoundsValidator getInstance() {
        return totalNumberOfRoundsValidator;
    }

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
