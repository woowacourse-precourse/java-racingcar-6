package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.MessageEnum;
import racingcar.model.NumberEnum;

public class UserService {
    public String inputItem() {
        return Console.readLine();
    }

    public int inputTryNumber(String tryNumber) {
        try {
            validateAll(tryNumber);
            return Integer.parseInt(tryNumber);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(MessageEnum.INVALID_INPUT_MESSAGE.getMessage());
        }
    }

    private void validateMinTryNumber(String tryNumber) {
        if (Integer.parseInt(tryNumber) < NumberEnum.MIN_TRY_NUMBER.getNumber()) {
            throw new IllegalArgumentException(MessageEnum.UNDER_MIN_TRY_NUMBER.getMessage());
        }
    }

    private void validateInvalidInputNumber(String tryNumber) {
        if (Integer.parseInt(tryNumber) < NumberEnum.ZERO.getNumber()) {
            throw new IllegalArgumentException(MessageEnum.INVALID_INPUT_MESSAGE.getMessage());
        }

    }

    private void validateAll(String tryNumber) {
        validateInvalidInputNumber(tryNumber);
        validateMinTryNumber(tryNumber);
    }
}
