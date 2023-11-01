package racingcar.utils.validator;

import static racingcar.utils.constants.RacingCarGameConstants.COMMA_DELIMITER;
import static racingcar.utils.constants.RacingCarGameConstants.INPUT_ERROR_MESSAGE;

import java.util.Arrays;
import java.util.List;

public class CarNameValidator implements Validator{

    private static final int MAX_LENGTH = 5;

    @Override
    public void validate(String context) {
        List<String> carNames = Arrays.asList(context.split(COMMA_DELIMITER));
        if (carNames.isEmpty()) throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        checkNameLength(carNames);
    }

    private void checkNameLength(List<String> carNames) {
        for (String carName : carNames) {
            carName=carName.trim();
            if (carName.length()> MAX_LENGTH || carName.isBlank()) {
                throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
            }
        }
    }
}
