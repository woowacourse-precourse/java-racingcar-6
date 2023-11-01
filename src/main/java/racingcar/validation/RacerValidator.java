package racingcar.validation;

import racingcar.constant.Rule;
import racingcar.constant.message.ErrorMessage;
import racingcar.constant.message.Message;
import racingcar.model.Racer;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class RacerValidator implements Validator {


    @Override
    public boolean support(Class<?> clazz) {
        return Racer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target) {
        validateNull((String) target);
        validateSize((String) target);
        validateSeparator((String) target);
        validateUnique((String) target);
    }

    private void validateNull(String value) {
        if (value == null) {
            throw new IllegalArgumentException(ErrorMessage.NO_PARTICIPANT);
        }
    }

    private void validateSize(String value) {
        if (value.trim().isEmpty() || value.split(Message.NAME_SEPARATOR).length < Rule.MIN_PARTICIPANT) {
            throw new IllegalArgumentException(ErrorMessage.NO_PARTICIPANT);
        }
    }

    private void validateSeparator(String value) {
        String doubleNameSeparator = Message.NAME_SEPARATOR.repeat(2);
        if (value.contains(doubleNameSeparator) || value.startsWith(Message.NAME_SEPARATOR)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SEPARATOR);
        }
    }

    private void validateUnique(String value) {
        Set<String> unique = Arrays.stream(value.split(Message.NAME_SEPARATOR))
                .map(String::trim)
                .collect(Collectors.toSet());
        if (unique.size() != value.split(Message.NAME_SEPARATOR).length) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NAME);
        }
    }
}
