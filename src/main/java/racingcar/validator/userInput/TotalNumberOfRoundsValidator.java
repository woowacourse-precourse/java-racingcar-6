package racingcar.validator.userInput;

import racingcar.constant.RacingGameConstants;
import racingcar.exception.round.NonPositiveIntegerException;

public class TotalNumberOfRoundsValidator extends UserInputValidator {

    private static TotalNumberOfRoundsValidator totalNumberOfRoundsValidator
            = new TotalNumberOfRoundsValidator();

    private TotalNumberOfRoundsValidator() {
    }

    public static TotalNumberOfRoundsValidator getInstance() {
        return totalNumberOfRoundsValidator;
    }

    @Override
    public void validate(String userInput) {
        validatePositiveInteger(userInput);
    }

    private void validatePositiveInteger(String userInput) {
        if (!RacingGameConstants.POSITIVE_INTEGER_PATTERN
                .matcher(userInput)
                .matches()) {
            throw new NonPositiveIntegerException();
        }
    }
}
