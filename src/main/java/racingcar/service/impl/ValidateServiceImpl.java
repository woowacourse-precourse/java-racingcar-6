package racingcar.service.impl;

import racingcar.message.ErrorMessage;
import racingcar.service.ValidateService;

public class ValidateServiceImpl implements ValidateService {
    @Override
    public void validateInputLastCharEqualCommas(String input) {
        char lastChar = input.charAt(input.length() - 1);
        ErrorMessage commasError = ErrorMessage.LAST_CHAR_COMMAS_ERROR;
        if (lastChar == ',') {
            throw new IllegalArgumentException(commasError.getMessage());
        }
    }

    @Override
    public void validateNamesSizeLessThanFive(String name) {
        ErrorMessage nameError = ErrorMessage.NAME_LENGTH_OVER_FOUR;
        if (name.length() >= 5) {
            throw new IllegalArgumentException(nameError.getMessage());
        }
    }
}
