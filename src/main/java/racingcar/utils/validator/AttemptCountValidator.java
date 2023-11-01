package racingcar.utils.validator;

import static racingcar.utils.constants.RacingCarGameConstants.*;
public class AttemptCountValidator implements Validator{

    public static final String DiGIT_REGEX = "[0-9]+";

    @Override
    public void validate(String context) {
        if (!context.matches(DiGIT_REGEX)) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }
}
