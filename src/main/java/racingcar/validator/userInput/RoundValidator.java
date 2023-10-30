package racingcar.validator.userInput;

import racingcar.constant.RacingGameConstants;
import racingcar.exception.round.NonPositiveIntegerException;

public class RoundValidator extends UserInputValidator {

    private static RoundValidator roundValidator = new RoundValidator();

    private RoundValidator(){};

    public static RoundValidator getInstance() {
        return roundValidator;
    }

    // 시도할 회수 입력 검증
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
