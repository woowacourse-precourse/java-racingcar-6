package racingcar.validator;

import racingcar.constant.ExceptionMessage;

public class CountInputValidator implements Validator<String> {

    @Override
    public void validate(String playerInput) {
        if (!playerInput.matches(ExceptionMessage.ONLY_NUMBER_REGEX.get())) {
            throwException(ExceptionMessage.COUNT_INPUT_EXCEPTION_MESSAGE.get());
        }
    }
}
