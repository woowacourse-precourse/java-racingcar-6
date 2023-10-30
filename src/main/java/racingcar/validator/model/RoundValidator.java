package racingcar.validator.model;

import racingcar.exception.round.NonPositiveIntegerException;
import racingcar.model.Round;

public class RoundValidator extends ModelValidator {
    private static RoundValidator roundValidator = new RoundValidator();

    private RoundValidator() {
    }

    public static RoundValidator getInstance() {
        return roundValidator;
    }

    @Override
    public void validate(Object target) {
        Round round = (Round) target;
        validateTotalNumberOfRounds(round.getTotalNumberOfRounds());
    }

    private void validateTotalNumberOfRounds(int totalNumberOfRounds) {
        if (totalNumberOfRounds < 0) {
            throw new NonPositiveIntegerException();
        }
    }
}
