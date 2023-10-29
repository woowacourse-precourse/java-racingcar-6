package racingcar.validation;

import racingcar.constant.Rule;
import racingcar.model.Racer;

import static racingcar.constant.Rule.NAME_SEPARATOR;

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
        if (value == null || value.split(NAME_SEPARATOR).length < Rule.MIN_PARTICIPANT) {
            throw new IllegalArgumentException("참가자가 없습니다.");
        }
    }
}
