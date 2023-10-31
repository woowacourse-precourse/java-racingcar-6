package racingcar.validator;

import racingcar.util.ExceptionMessage;

import java.util.List;

public class NamesCountValidator implements Validator<List<String>> {

    @Override
    public void validate(List<String> carNames) {
        if (carNames.size() <= 1) {
            throwException(ExceptionMessage.NAMES_COUNT_EXCEPTION_MESSAGE.get());
        }
    }
}
