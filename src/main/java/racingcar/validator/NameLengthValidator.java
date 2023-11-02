package racingcar.validator;

import racingcar.constant.ExceptionMessage;
import racingcar.constant.GameSettingNumber;

public class NameLengthValidator implements Validator<String> {

    @Override
    public void validate(String name) {
        if (name.isEmpty() || name.length() > GameSettingNumber.MAX_LENGTH.get()) {
            throwException(ExceptionMessage.NAME_LENGTH_EXCEPTION_MESSAGE.get());
        }
    }
}
