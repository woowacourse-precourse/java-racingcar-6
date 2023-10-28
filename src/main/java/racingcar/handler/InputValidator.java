package racingcar.handler;

import static racingcar.constant.ErrorMessage.CAR_NAME_LENGTH_ERROR;
import static racingcar.constant.ErrorMessage.EMPTY_STRING_ERROR;
import static racingcar.constant.ErrorMessage.NON_NUMERIC_ERROR;
import static racingcar.constant.GameConstant.MAX_CAR_NAME_LENGTH;
import static racingcar.handler.InputConvertor.COMMA_DELIMITER;

import java.util.Arrays;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class InputValidator {

    public void validateCarName(String input) {
        validBlankInput(input);

        List<String> carNames = Arrays.stream(input.split(COMMA_DELIMITER))
            .toList();

        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH.getValue()) {
                throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR.getMessage());
            }
        }
    }

    public void validateNumericInput(String input) {
        validBlankInput(input);

        try {
            Integer.parseInt(input);
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
