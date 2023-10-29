package racingcar.handler;

import static racingcar.constant.ErrorMessage.CAR_NAME_LENGTH_ERROR;
import static racingcar.constant.ErrorMessage.EMPTY_STRING_ERROR;
import static racingcar.constant.ErrorMessage.INVALID_RANGE_ERROR;
import static racingcar.constant.ErrorMessage.NON_NUMERIC_ERROR;
import static racingcar.handler.InputConvertor.COMMA_DELIMITER;

import java.util.Arrays;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class InputValidator {
    private final static int MAX_CAR_NAME_LENGTH = 5;
    public void validateCarName(String input) {
        validBlankInput(input);

        List<String> carNames = Arrays.stream(input.split(COMMA_DELIMITER))
            .map(name -> name.replaceAll(" ", ""))
            .toList();

        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR.getMessage());
            }
        }
    }

    public void validateNumericInput(String input) {
        validBlankInput(input);

        try {
            int number = Integer.parseInt(input);

            if(number < 1) {
                throw new IllegalArgumentException(INVALID_RANGE_ERROR.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR.getMessage());
        }
    }

    private void validBlankInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(EMPTY_STRING_ERROR.getMessage());
        }
    }
}
