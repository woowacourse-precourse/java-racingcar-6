package racingcar.support.validator;

import racingcar.exceptions.argument.InvalidCarNameTypeException;
import racingcar.exceptions.argument.OverCarNameLengthLimitException;
import racingcar.support.SystemProperty;
import racingcar.utils.EnglishMatcher;

public class CarNameValidator {

    private static final Long maxNameLength = Long.valueOf(SystemProperty.MAX_CAR_NAME_LENGTH);

    private CarNameValidator() {
    }

    public static void validate(String source) {
        if (!EnglishMatcher.isEnglish(source)) {
            throw new InvalidCarNameTypeException();
        }
        if (source.length() > maxNameLength) {
            throw new OverCarNameLengthLimitException();
        }
    }
}
