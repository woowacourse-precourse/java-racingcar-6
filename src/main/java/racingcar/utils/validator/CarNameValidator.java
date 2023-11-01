package racingcar.utils.validator;

import static racingcar.utils.constants.RacingCarGameConstants.COMMA_DELIMITER;
import static racingcar.utils.constants.RacingCarGameConstants.INPUT_ERROR_MESSAGE;

public class CarNameValidator implements Validator{

    private static final int MAX_LENGTH = 5;

    @Override
    public void validate(String context) {
        String[] carNames = context.split(COMMA_DELIMITER);
        checkNameLength(carNames);
    }

    private void checkNameLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length()> MAX_LENGTH || carName.isBlank()) {
                throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
            }
        }
    }
}
