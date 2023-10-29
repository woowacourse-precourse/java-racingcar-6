package racingcar.validation;

import racingcar.constant.Rule;
import racingcar.constant.message.ErrorMessage;
import racingcar.constant.message.Message;
import racingcar.model.Racer;

public class RacerValidator implements Validator {


    @Override
    public boolean support(Class<?> clazz) {
        return Racer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target) {
        validateSize((String) target);
    }

    private void validateSize(String value) {
        if (value == null || value.split(Message.NAME_SEPARATOR).length < Rule.MIN_PARTICIPANT) {
            throw new IllegalArgumentException(ErrorMessage.NO_PARTICIPANT);
        }
    }
}
